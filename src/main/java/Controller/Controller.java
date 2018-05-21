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


    public void escapeCallback() {
        model.pauseOrExit();
    }


    public void checkboxExampleCallback(String checkboxID) {
        model.toggleCheckbox(checkboxID);
    }


    public void fieldClickCallback(int row, int column) {
        //TODO: actions - selection, deselection units etc.
        model.updateFieldCell(row, column);
    }
}
