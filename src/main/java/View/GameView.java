package View;

import Controller.Controller;


public class GameView implements AutoCloseable {

    private Controller controller;


    public GameView() {
        System.out.println("GameView      : ()");
        GameRenderer.init();
    }


    public void close() {
        GameRenderer.finish();
    }


    public void run() {
        if(controller == null) {
            throw new IllegalStateException("Controller должен быть установлен до запуска GameView");
        }

        try(GameRenderer gameRenderer = new GameRenderer(this)) {
            gameRenderer.createWindow();
            gameRenderer.run();
        }
    }


    public void setController(Controller controller) {
        System.out.println("GameView      : adding controller");
        this.controller = controller;
    }
}


