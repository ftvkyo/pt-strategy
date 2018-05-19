package Controller;

import Model.Model;
import View.Notification.CheckboxUpdate;


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


    public void escapeCallback() {
        model.pauseOrExit();
    }


    public void checkboxExampleCallback(CheckboxUpdate cu) {
        model.toggleCheckbox(cu);
    }
}
