package Model;

import View.Notification.CheckboxUpdate;
import View.Notification.INotificationReceiver;
import View.Notification.WindowChange;


public class Model{

    private INotificationReceiver reciever;


    private boolean checkbox = false;


    public void setReciever(INotificationReceiver reciever) {
        this.reciever = reciever;
    }


    public void beginGame() {
        reciever.receiveNotification(WindowChange.SWITCH_TO_GAME);
    }


    public void pauseOrExit() {
        reciever.receiveNotification(WindowChange.SWITCH_TO_SETTINGS_OR_EXIT);
    }


    public void reset() {
    }


    public void toggleCheckbox(String checkboxID) {
        checkbox = !checkbox;
        reciever.receiveNotification(new CheckboxUpdate(checkboxID, checkbox));
    }
}
