package Controller;

import Model.Model;


/**
 *
 */
public class Controller implements AutoCloseable {

    Model model;


    public void close() {

    }


    public void setModel(Model model) {
        this.model = model;
    }


    public enum Callback {
        START_GAME,
        RESTART_GAME,
        ESC_GAME
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
