package Controller;

import Model.GameModel;


/**
 *
 */
public class Controller implements Runnable {

    private GameModel model;


    public Controller() {
        System.out.println("Controller : ()");
    }


    public void setGameModel(GameModel m) {//FIXME
        System.out.println("Controller : adding model");
        this.model = m;
    }


    public void run() {

    }
}
