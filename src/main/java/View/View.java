package View;

import Controller.Controller;
import View.InterfaceDescription.RenderableDescription;
import View.InterfaceDescription.ViewDescription;
import View.Misc.Renderable;
import View.Notification.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class View implements INotificationReceiver {

    private boolean shouldClose = false;

    private Map<String, Renderable> screens = new HashMap<>();
    private String currentScreen;

    private Controller controller;


    public View(Controller controller, @NotNull ViewDescription description) {
        this.controller = controller;

        for(Map.Entry<String, RenderableDescription> screen : description.availableScreens.entrySet()) {
            screens.put(screen.getKey(), new Renderable(controller, screen.getKey(), screen.getValue()));
        }
        currentScreen = description.initialScreen;
    }


    @Override
    public void receiveNotification(INotification n) {
        if(n instanceof WindowChange) {
            if(n == WindowChange.SWITCH_TO_SETTINGS_OR_EXIT) {
                if(currentScreen.equals("settings-screen")) {
                    shouldClose = true;
                } else if(currentScreen.equals("ingame-screen")) {
                    currentScreen = "settings-screen";
                }
            } else if(n == WindowChange.SWITCH_TO_GAME) {
                currentScreen = "ingame-screen";
            }
        } else if(n instanceof CheckboxUpdate) {
            screens.get(currentScreen).receiveNotification(n);
        } else if(n instanceof FieldUpdate) {
            screens.get("ingame-screen").receiveNotification(n);
        }
    }


    public void render() {
        screens.get(currentScreen).render();
    }


    public void clickEvent(float xPosition, float yPosition) {
        screens.get(currentScreen).clickEvent(xPosition, yPosition);
    }


    public boolean getShouldClose() {
        return shouldClose;
    }
}
