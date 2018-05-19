package Model;

import View.Notification.CheckboxUpdate;
import View.Notification.INotificationReciever;
import View.Notification.WindowChange;


public class Model{

    private INotificationReciever reciever;


    private boolean checkbox = false;


    public void setReciever(INotificationReciever reciever) {
        this.reciever = reciever;
    }


    public void beginGame() {
        reciever.sendNotification(WindowChange.SWITCH_TO_GAME);
    }


    public void pauseOrExit() {
        reciever.sendNotification(WindowChange.SWITCH_TO_SETTINGS_OR_EXIT);
    }


    public void reset() {
    }


    public void toggleCheckbox(CheckboxUpdate cu) {
        checkbox = !checkbox;
        cu.update(checkbox);
    }
}
