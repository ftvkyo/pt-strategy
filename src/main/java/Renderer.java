import Controller.Controller;
import View.View;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Renderer implements Runnable, AutoCloseable {

    static void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit()) {
            throw new IllegalStateException("Не получилось инициализировать GLFW.");
        }
    }


    static void finish() {
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();
    }


    private long currentWindow;

    private int windowWidth = 16;
    private int realWindowWidth = 1920;

    private int windowHeight = 9;
    private int realWindowHeight = 1080;


    private View view;
    private Controller controller;


    Renderer(float internalWidth, float internalHeight) {
        windowWidth = (int) internalWidth;
        windowHeight = (int) internalHeight;
    }


    public void close() {
        glfwFreeCallbacks(currentWindow);
        glfwDestroyWindow(currentWindow);
    }


    public void run() {
        currentWindow = createWindow();

        glClearColor(0f, 0f, 0f, 0.0f);

        while(!glfwWindowShouldClose(currentWindow)) {
            // Poll for currentWindow events. The key callbacks will only be
            // invoked during this call.
            glfwWaitEventsTimeout(0.1);


            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            view.render();
            if(view.getShouldClose()) {
                glfwSetWindowShouldClose(currentWindow, true);
            }

            glfwSwapBuffers(currentWindow);
        }
    }


    public void setView(View view) {
        this.view = view;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }


    private long createWindow() {
        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_ANY_PROFILE);

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);


        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);
        if(vidmode == null) {
            throw new RuntimeException("Не удалось получить видеорежим текущего монитора");
        }
        if(vidmode.height() * 16 > vidmode.width() * 9) {
            realWindowWidth = vidmode.width();
            realWindowHeight = realWindowWidth * windowHeight / windowWidth;
        } else if(vidmode.height() * windowWidth < vidmode.width() * windowHeight) {
            realWindowHeight = vidmode.height();
            realWindowWidth = realWindowHeight * windowWidth / windowHeight;
        }


        long window = glfwCreateWindow(
                realWindowWidth,
                realWindowHeight,
                "pt-strategy",
                monitor,
                NULL
        );
        if(window == NULL) {
            throw new RuntimeException("Не получилось создать окно с помощью GLFW");
        }

        glfwSetKeyCallback(window, this::keyPressCallback);
        glfwSetMouseButtonCallback(window, this::mouseClickCallback);
        glfwSetWindowSizeCallback(window, this::windowResizeCallback);

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the currentWindow visible
        glfwShowWindow(window);

        GL.createCapabilities();
        windowResizeCallback(window, realWindowWidth, realWindowHeight);

        return window;
    }


    public void transformClick(double[] xPosition, double[] yPosition) {
        xPosition[0] *= (double) windowWidth / realWindowWidth;
        yPosition[0] *= (double) windowHeight / realWindowHeight;
    }


    private void keyPressCallback(long window, long key, long scancode, long action, long mods) {
        if(action == GLFW_RELEASE) {
            if(key == GLFW_KEY_ESCAPE) {
                controller.getCallback("escape-button").run();
            }
        }
    }


    private void mouseClickCallback(long window, long button, long action, long mods) {
        if(action == GLFW_RELEASE) {
            double[] xPosition = {0}, yPosition = {0};
            glfwGetCursorPos(window, xPosition, yPosition);
            transformClick(xPosition, yPosition);

            view.clickEvent((float) xPosition[0], (float) yPosition[0]);
        }
    }


    private void windowResizeCallback(long window, int width, int height) {
        realWindowWidth = width;
        realWindowHeight = height;

        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0f, (double) windowWidth, (double) windowHeight, 0.0f, 0.0f, 1.0f);
        glMatrixMode(GL_MODELVIEW);
    }
}
