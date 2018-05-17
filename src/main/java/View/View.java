package View;

import Controller.Controller;
import View.Misc.InterfaceElement;
import View.Notification.INotification;
import View.Notification.WindowChange;


public class View implements AutoCloseable, Runnable {

    private static boolean rendererInitialized = false;

    private Controller controller;

    InterfaceElement interfaceElement;

    private InterfaceElement settingsInterfaceElement;

    private InterfaceElement gameInterfaceElement;

    Renderer renderer;


    public View(Controller controller) {
        System.out.println("View: ()");
        if(!rendererInitialized) {
            Renderer.init();
            rendererInitialized = true;
        }

        this.controller = controller;

        settingsInterfaceElement = new SettingsInterfaceElement(this);
        gameInterfaceElement = new GameInterfaceElement(this);

        this.interfaceElement = settingsInterfaceElement;

        renderer = new Renderer(this, controller);
    }


    public void close() {
        System.out.println("View: close()");
        if(rendererInitialized) {
            Renderer.finish();
            rendererInitialized = false;
        }
    }


    public void run() {
        renderer.createWindow();
        renderer.run();
        renderer.close();
    }


    public Runnable getCallback(Controller.Callback c) {
        switch(c) {
            case START_GAME:
                return controller::startGameCallback;
            case RESTART_GAME:
                return controller::restartGameCallback;
            case ESC_GAME:
                return controller::escapeGameCallback;
        }
        return null;
    }


    public void sendNotification(INotification n) {
        if(n instanceof WindowChange) {
            if(n == WindowChange.SWITCH_TO_GAME) {
                interfaceElement = gameInterfaceElement;
            } else if(n == WindowChange.SWITCH_TO_SETTINGS_OR_EXIT) {
                if(interfaceElement.equals(gameInterfaceElement)) {
                    interfaceElement = settingsInterfaceElement;
                } else {
                    renderer.setShouldClose();
                }
            }
        }
    }
}
