package View;

import View.Interface.Game;
import View.Interface.Renderable;
import View.Interface.Settings;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;


public class Renderer implements Runnable, AutoCloseable {

    private long window;

    private int windowHeight = 1080;

    private int windowWidth = 1920;

    private View view;

    Renderable settings;

    Renderable game;

    Renderable state;


    public Renderer(View v) {
        view = v;
        game = new Game();
        settings = new Settings();

        state = settings;
    }


    public static void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if(!glfwInit()) {
            throw new IllegalStateException("Не получилось инициализировать GLFW.");
        }
    }


    public static void finish() {
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }


    public void close() {
        System.out.println("Renderer  : close()");

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
    }


    public void createWindow() {
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);


        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);
        if(vidmode == null) {
            throw new RuntimeException("Не удалось получить видеорежим текущего монитора");
        }
        if(vidmode.height() * 16 > vidmode.width() * 9) {
            windowWidth = vidmode.width();
            windowHeight = windowWidth * 9 / 16;
        } else if(vidmode.height() * 16 < vidmode.width() * 9) {
            windowHeight = vidmode.height();
            windowWidth = windowHeight * 16 / 9;
        }


        window = glfwCreateWindow(
                windowWidth,
                windowHeight,
                "pt-strategy",
                monitor,
                NULL
        );
        if(window == NULL) {
            throw new RuntimeException("Не получилось создать окно с помощью GLFW");
        }

        glfwSetKeyCallback(window, this::keyPressCallback);
        glfwSetMouseButtonCallback(window, this::mouseClickCallback);

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        GL.createCapabilities();


        glViewport(0, 0, windowWidth, windowHeight);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0f, (double) windowWidth, (double) windowHeight, 0.0f, 0.0f, 1.0f); //TODO: call on resize?
        glMatrixMode(GL_MODELVIEW);
    }


    public void run() {
        glClearColor(0f, 0f, 0f, 0.0f);

        while(!glfwWindowShouldClose(window)) {
            handleInput();
            render();
        }
    }


    private void handleInput() {
        // Poll for window events. The key callbacks will only be
        // invoked during this call.
        glfwWaitEventsTimeout(0.1);
    }


    private void render() {
        clearBuffer();

        state.render();

        glfwSwapBuffers(window);
    }


    private void clearBuffer() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }


    private void keyPressCallback(long window, long key, long scancode, long action, long mods) {
        if(action == GLFW_RELEASE) {
            if(key == GLFW_KEY_ESCAPE) {
                System.out.println("ESC pressed");
                if(state.equals(settings)) {
                    glfwSetWindowShouldClose(window, true);
                } else if(state.equals(game)) {
                    state = settings;
                }
            } else if(key == GLFW_KEY_S) {
                System.out.println("S pressed");
                if(state.equals(settings)) {
                    state = game;
                }
            }
        }
    }


    private void mouseClickCallback(long window, long button, long action, long mods) {
        if(action == GLFW_RELEASE) {
            double[] xpos = {0}, ypos = {0};
            glfwGetCursorPos(window, xpos, ypos);

            if((mods & GLFW_MOD_CONTROL) != 0) {
                System.out.println("Mouse click [with CTRL]");
            } else {
                System.out.println("Mouse click");
            }

            state.clickEvent((float) xpos[0], (float) ypos[0]);
        }
    }
}
