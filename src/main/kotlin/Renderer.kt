import Controller.Controller
import View.View
import org.lwjgl.glfw.Callbacks.glfwFreeCallbacks
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL


class Renderer : Runnable, AutoCloseable {


    private var currentWindow: Long = 0
    private var realWindowHeight = 1080
    private var realWindowWidth = 1920


    private var view: View? = null
    private var controller: Controller? = null


    override fun close() {
        glfwFreeCallbacks(currentWindow)
        glfwDestroyWindow(currentWindow)
    }


    override fun run() {
        currentWindow = createWindow()

        glClearColor(0f, 0f, 0f, 0.0f)

        while (!glfwWindowShouldClose(currentWindow)) {
            // Poll for currentWindow events. The key callbacks will only be
            // invoked during this call.
            glfwWaitEventsTimeout(0.1)


            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)

            view!!.render()
            if (view!!.shouldClose) {
                glfwSetWindowShouldClose(currentWindow, true)
            }

            glfwSwapBuffers(currentWindow)
        }
    }


    fun setView(view: View) {
        this.view = view
    }


    fun setController(controller: Controller) {
        this.controller = controller
    }


    private fun createWindow(): Long {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)


        val monitor = glfwGetPrimaryMonitor()
        val vidmode = glfwGetVideoMode(monitor)
                ?: throw RuntimeException("Не удалось получить видеорежим текущего монитора")
        if (vidmode.height() * 16 > vidmode.width() * 9) {
            realWindowWidth = vidmode.width()
            realWindowHeight = realWindowWidth * windowHeight / windowWidth
        } else if (vidmode.height() * windowWidth < vidmode.width() * windowHeight) {
            realWindowHeight = vidmode.height()
            realWindowWidth = realWindowHeight * windowWidth / windowHeight
        }


        val window = glfwCreateWindow(
                realWindowWidth,
                realWindowHeight,
                "pt-strategy",
                monitor,
                NULL
        )
        if (window == NULL) {
            throw RuntimeException("Не получилось создать окно с помощью GLFW")
        }

        glfwSetKeyCallback(window, ::keyPressCallback)
        glfwSetMouseButtonCallback(window, ::mouseClickCallback)
        glfwSetWindowSizeCallback(window, ::windowResizeCallback)

        // Make the OpenGL context current
        glfwMakeContextCurrent(window)
        // Enable v-sync
        glfwSwapInterval(1)

        // Make the currentWindow visible
        glfwShowWindow(window)

        GL.createCapabilities()
        windowResizeCallback(window, realWindowWidth, realWindowHeight)

        return window
    }


    private fun transformClick(xPosition: DoubleArray, yPosition: DoubleArray) {
        xPosition[0] *= windowWidth.toDouble() / realWindowWidth
        yPosition[0] *= windowHeight.toDouble() / realWindowHeight
    }


    private fun keyPressCallback(window: Long, key: Int, scancode: Int, action: Int, mods: Int) {
        if (action == GLFW_RELEASE) {
            if (key == GLFW_KEY_ESCAPE) {
                controller!!.escapeCallback()
            }
        }
    }


    private fun mouseClickCallback(window: Long, button: Int, action: Int, mods: Int) {
        if (action == GLFW_RELEASE) {
            val xPosition = doubleArrayOf(0.0)
            val yPosition = doubleArrayOf(0.0)
            glfwGetCursorPos(window, xPosition, yPosition)
            transformClick(xPosition, yPosition)

            view!!.clickEvent(xPosition[0].toFloat(), yPosition[0].toFloat())
        }
    }


    private fun windowResizeCallback(window: Long, width: Int, height: Int) {
        realWindowWidth = width
        realWindowHeight = height

        glViewport(0, 0, width, height)
        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glOrtho(0.0, windowWidth.toDouble(), windowHeight.toDouble(), 0.0, 0.0, 1.0)
        glMatrixMode(GL_MODELVIEW)
    }


    companion object {

        internal fun init() {
            GLFWErrorCallback.createPrint(System.err).set()
            if (!glfwInit()) {
                throw IllegalStateException("Не получилось инициализировать GLFW.")
            }
        }


        internal fun finish() {
            glfwTerminate()
            glfwSetErrorCallback(null)?.free()
        }

        const val windowHeight = 9

        const val windowWidth = 16
    }
}
