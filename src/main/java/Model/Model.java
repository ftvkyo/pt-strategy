package Model;

import View.Notification.CheckboxUpdate;
import View.Notification.INotificationReceiver;
import View.Notification.WindowChange;


public class Model{

    private INotificationReceiver receiver;


    private boolean checkbox = false;


    public void setReceiver(INotificationReceiver receiver) {
        this.receiver = receiver;
    }


    public void beginGame() {
        receiver.receiveNotification(WindowChange.SWITCH_TO_GAME);
    }


    public void pauseOrExit() {
        receiver.receiveNotification(WindowChange.SWITCH_TO_SETTINGS_OR_EXIT);
    }


    public void reset() {
    }


    public void toggleCheckbox(String checkboxID) {
        checkbox = !checkbox;
        receiver.receiveNotification(new CheckboxUpdate(checkboxID, checkbox));
    }
}
