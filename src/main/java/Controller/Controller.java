package Controller;

import Model.Model;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
public class Controller{

    Model model;

    private Map<String, Runnable> buttonAndCheckboxCallbacks = new HashMap<>();
    {
        buttonAndCheckboxCallbacks.put("startGame-button", this::startGameCallback);
        buttonAndCheckboxCallbacks.put("restartGame-button", this::restartGameCallback);
        buttonAndCheckboxCallbacks.put("escape-button", this::escapeCallback);
        buttonAndCheckboxCallbacks.put("example-checkbox", this::exampleCheckboxCallback);
    }


    public void setModel(Model model) {
        this.model = model;
    }


    public Runnable getCallback(String callbackID) {
        return buttonAndCheckboxCallbacks.get(callbackID);
    }


    private void startGameCallback() {
        model.beginGame();
    }


    private void restartGameCallback() {
        model.reset();
        startGameCallback();
    }


    private void escapeCallback() {
        model.pauseOrExit();
    }


    public void exampleCheckboxCallback() {
        model.toggleExampleCheckbox();
    }


    public void fieldClickCallback(int row, int column) {
        //TODO: actions - selection, deselection units etc.
        model.updateFieldCell(row, column);
    }
}
