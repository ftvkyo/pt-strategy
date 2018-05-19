package Controller;

import Model.Model;


/**
 *
 */
public class Controller{

    Model model;


    public void setModel(Model model) {
        this.model = model;
    }


    public void startGameCallback() {
        model.beginGame();
    }


    public void restartGameCallback() {
        model.reset();
        startGameCallback();
    }


    public void escapeGameCallback() {
        model.pauseOrExit();
    }
}
