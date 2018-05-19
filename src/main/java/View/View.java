package View;

import Controller.Controller;
import View.Misc.Checkbox;
import View.Misc.Renderable;
import View.Notification.CheckboxUpdate;
import View.Notification.INotification;
import View.Notification.INotificationReceiver;
import View.Notification.WindowChange;

import java.util.HashMap;
import java.util.Map;

public class View extends Renderable implements INotificationReceiver {

    private boolean shouldClose = false;

    private Renderable currentRenderable;

    private Renderable settingsRenderable;
    private Renderable gameRenderable;

    private Controller controller;


    /**
     * Сюда помещаются Renderables, которые либо показаны на нескольких экранах,
     * либо имеют состояние, которое надо именять по их ID.
     * Фактически, первый параметр - это ID.
     */
    private Map<String, Renderable> interfaceElements = new HashMap<>();


    public View(float windowWidth, float windowHeight) {
        this.setRectangle(0f, windowWidth, windowHeight, 0f);

        /* *****************
         *
         * ELEMENTS CREATION
         *
         * *****************/
        Checkbox exampleCheckbox = new Checkbox();
        exampleCheckbox.setAction( () -> controller.checkboxExampleCallback("exampleCheckbox") )
                .setColor(0.5f, 0.5f, 0.5f)
                .setRectangle(1f, 2f, 2f, 1f);
        interfaceElements.put("exampleCheckbox", exampleCheckbox);

        interfaceElements.put("escapeButton",
                new Renderable()
                        .setColor(1f, 0f, 0f)
                        .setRectangle(15f, 15.5f, 1f, 0.5f)
                        .setAction( () -> controller.escapeCallback() )
                );


        /* *****************
         *
         * RENDERABLES SETUP
         *
         * *****************/
        settingsRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new Renderable()
                        .setColor(0.9f, 0.5f, 0.5f)
                        .setRectangle(12f, 13.5f, 8.5f, 8f)
                        .setAction( () -> controller.restartGameCallback() ))
                .addChild(new Renderable()
                        .setColor(0.5f, 0.9f, 0.5f)
                        .setRectangle(14f, 15.5f, 8.5f, 8f)
                        .setAction( () -> controller.startGameCallback() ))
                .addChild(interfaceElements.get("escapeButton"))
                .addChild(interfaceElements.get("exampleCheckbox"));


        gameRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new GameMapRenderable()
                        .setRectangle(0f, 9, windowHeight, 0f)
                )
                .addChild(new GameMenuRenderable()
                        .setRectangle(9, windowWidth, windowHeight, 0f)
                        .addChild(interfaceElements.get("escapeButton"))
                );


        currentRenderable = settingsRenderable;
    }


    @Override
    public void receiveNotification(INotification n) {
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
            ((Checkbox) interfaceElements.get(((CheckboxUpdate) n).getCheckboxID()))
                    .setChecked(((CheckboxUpdate) n).getUpdateTo());
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


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
        gameRenderable.setController(controller);
        settingsRenderable.setController(controller);
    }


    public boolean getShouldClose() {
        return shouldClose;
    }
}
