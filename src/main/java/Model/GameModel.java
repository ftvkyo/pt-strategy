package Model;

import View.GameView;

/**
 *
 */
public class GameModel {

    private GameView view;


    public GameModel() {
        System.out.println("GameModel     : ()");
    }


    public void setView(GameView view) {
        System.out.println("GameModel     : setting view");
        this.view = view;
    }
}
