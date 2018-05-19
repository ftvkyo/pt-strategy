package View;

import Controller.Controller;
import View.Misc.Checkbox;
import View.Misc.Renderable;
import View.Notification.CheckboxUpdate;
import View.Notification.INotification;
import View.Notification.INotificationReciever;
import View.Notification.WindowChange;

import java.util.HashMap;
import java.util.Map;

public class View extends Renderable implements INotificationReciever {

    private boolean shouldClose = false;

    private Renderable currentRenderable;

    private Renderable settingsRenderable;
    private Renderable gameRenderable;

    private Controller controller;


    private Map<String, Renderable> interfaceElements = new HashMap<>();


    public View(float windowWidth, float windowHeight) {
        this.setRectangle(0f, windowWidth, windowHeight, 0f);


        Checkbox exampleCheckbox = new Checkbox();
        exampleCheckbox.setAction( () -> controller.checkboxExampleCallback(exampleCheckbox.getUpdater()) )
                .setColor(0.5f, 0.5f, 0.5f)
                .setRectangle(14f, 15f, 4f, 3f);
        interfaceElements.put("exampleCheckbox", exampleCheckbox);

        interfaceElements.put("escapeButton",
                new Renderable()
                        .setColor(1f, 0f, 0f)
                        .setRectangle(14f, 15f, 2f, 1f)
                        .setAction( () -> controller.escapeCallback() )
                );


        settingsRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new Renderable()
                        .setColor(0.5f, 0.9f, 0.5f)
                        .setRectangle(1f, 2f, 2f, 1f)
                        .setAction( () -> controller.startGameCallback() ))
                .addChild(new Renderable()
                        .setColor(0.9f, 0.5f, 0.5f)
                        .setRectangle(3f, 4f, 2f, 1f)
                        .setAction( () -> controller.restartGameCallback() ))
                .addChild(interfaceElements.get("escapeButton"))
                .addChild(interfaceElements.get("exampleCheckbox"));

        gameRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new GameMapRenderable()
                        .setRectangle(0f, windowWidth * 0.66f, windowHeight, 0f)
                )
                .addChild(new GameMenuRenderable()
                        .setRectangle(windowWidth * 0.66f, windowWidth, windowHeight, 0f)
                        .addChild(interfaceElements.get("escapeButton"))
                );

        currentRenderable = settingsRenderable;
    }


    @Override
    public void sendNotification(INotification n) {
        if(n instanceof WindowChange) {
            if(n == WindowChange.SWITCH_TO_SETTINGS_OR_EXIT) {
                if(currentRenderable.equals(settingsRenderable)) {
                    shouldClose = true;
                } else if(currentRenderable.equals(gameRenderable)) {
                    currentRenderable = settingsRenderable;
                }
            } else if(n == WindowChange.SWITCH_TO_GAME) {
                currentRenderable = gameRenderable;
            }
        } else if(n instanceof CheckboxUpdate) {

        }
    }


    @Override
    protected void renderState() {
        currentRenderable.render();
    }


    @Override
    public void clickEvent(float xPosition, float yPosition) {
        currentRenderable.clickEvent(xPosition, yPosition);
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }


    public boolean getShouldClose() {
        return shouldClose;
    }
}
