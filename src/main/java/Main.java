import Controller.Controller;
import Model.GameModel;
import View.GameView;
import View.SettingsView;


public class Main {

    public static void main(String[] args) {
        try(GameView gameView = new GameView();
                SettingsView settingsView = new SettingsView()) {

            GameModel gameModel = new GameModel();
            Controller controller = new Controller();


            gameModel.setView(gameView);
            settingsModel.setView(settingsView);

            gameView.setController(controller);
            settingsView.setController(controller);

            controller.setGameModel(gameModel);
            controller.setSettingsModel(settingsModel);


            controller.run();
        }
    }
}
