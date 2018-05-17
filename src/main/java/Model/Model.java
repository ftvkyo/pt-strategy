package Model;

import View.Notification.WindowChange;
import View.View;


public class Model implements AutoCloseable {

    private View view;


    public Model() {
        System.out.println("Model: ()");
    }


    public void close() {

    }


    public void setView(View view) {
        System.out.println("Model: setting view");
        this.view = view;
    }


    public void beginGame() {
        view.sendNotification(WindowChange.SWITCH_TO_GAME);
    }


    public void pauseOrExit() {
        view.sendNotification(WindowChange.SWITCH_TO_SETTINGS_OR_EXIT);
    }


    public void reset() {
    }
}
