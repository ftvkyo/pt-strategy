package View.Notification;

import View.Misc.Checkbox;


public class CheckboxUpdate implements INotification {

    private Checkbox c;


    public CheckboxUpdate(Checkbox c) {
        this.c = c;
    }


    public void update(boolean state) {
        c.setChecked(state);
    }
}
