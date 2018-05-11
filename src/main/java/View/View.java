package View;

import Controller.Controller;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class View implements java.util.Observer, java.lang.AutoCloseable {

    public View() {
        System.out.println("View      : ()");

        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
    }


    public void run() {
        long window = createWindow();
        gameLoop(window);

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

    }


    public void close() {
        System.out.println("View      : close()");
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }


    // Called from the Model
    public void update(Observable obs, Object obj) {

        //who called us and what did they send?
        System.out.println("View      : Observable is " + obs.getClass() + ", object passed is " + obj.getClass());
    }


    public void addController(Controller controller){
        System.out.println("View      : adding controller");
    }


    private long createWindow() {
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);


        long window = glfwCreateWindow(600, 450, "Hello World!", NULL, NULL);
        if(window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetKeyCallback(window, (w, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(w, true);
        });

        // Get the thread stack and push a new frame
        try(MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        return window;
    }


    private void gameLoop(long window) {
        GL.createCapabilities();

        glClearColor(0.9f, 0.5f, 0.5f, 0.0f);

        Triangle t = new Triangle();
        t.x1 = 0.2f;
        t.x2 = 0.3f;
        t.x3 = 0.1f;
        t.y1 = 0.1f;
        t.y2 = 0.4f;
        t.y3 = 0.4f;

        TimerTask move = new MoveTriangle();
        ((MoveTriangle) move).setTriangle(t);
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(move, 0, 15);

        while(!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer


            glBegin(GL_TRIANGLES);
            glVertex2f(t.x1, t.y1);
            glVertex2f(t.x2, t.y2);
            glVertex2f(t.x3, t.y3);
            glEnd();

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }


    public static class Triangle {
        public float x1 = 0f, x2 = 0f, x3 = 0f;
        public float y1 = 0f, y2 = 0f, y3 = 0f;
    }


    public static class MoveTriangle extends TimerTask {
        private Triangle t;

        @Override
        public void run() {
            t.x1 += 0.001f;
            t.x2 += 0.001f;
            t.x3 += 0.001f;
        }

        public void setTriangle(Triangle t) {
            this.t = t;
        }
    }
}


