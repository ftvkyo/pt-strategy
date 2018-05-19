package View;

import Controller.Controller;
import View.Misc.Renderable;
import View.Notification.INotification;
import View.Notification.INotificationReciever;
import View.Notification.WindowChange;


public class View extends Renderable implements INotificationReciever {

    private boolean shouldClose = false;

    private Renderable currentRenderable;

    private Renderable settingsRenderable;
    private Renderable gameRenderable;

    private Controller controller;


    public View(float windowWidth, float windowHeight) {
        this.setRectangle(0f, windowWidth, windowHeight, 0f);

        settingsRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new Renderable()
                        .setColor(0.5f, 0.9f, 0.5f)
                        .setRectangle(1f, 2f, 2f, 1f)
                        .setAction( () -> controller.startGameCallback() )
                )
                .addChild(new Renderable()
                        .setColor(0.9f, 0.5f, 0.5f)
                        .setRectangle(3f, 4f, 2f, 1f)
                        .setAction( () -> controller.restartGameCallback() )
                )
                .addChild(new Renderable()
                        .setColor(1f, 0f, 0f)
                        .setRectangle(14f, 15f, 2f, 1f)
                        .setAction( () -> controller.escapeGameCallback() )
                );

        gameRenderable = new Renderable()
                .setRectangle(0f, windowWidth, windowHeight, 0f)
                .addChild(new GameMapRenderable()
                        .setRectangle(0f, windowWidth * 0.66f, windowHeight, 0f)
                )
                .addChild(new GameMenuRenderable()
                        .setRectangle(windowWidth * 0.66f, windowWidth, windowHeight, 0f)
                        .addChild(new Renderable()
                                .setColor(1f, 0f, 0f)
                                .setRectangle(14f, 15f, 2f, 1f)
                                .setAction( () -> controller.escapeGameCallback() )
                        )
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
