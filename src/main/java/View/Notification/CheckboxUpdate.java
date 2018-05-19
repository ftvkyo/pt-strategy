package View.Notification;

public class CheckboxUpdate implements INotification {

    private String checkboxID;

    private boolean updateTo;


    public CheckboxUpdate(String checkboxID, boolean updateTo) {
        this.checkboxID = checkboxID;
        this.updateTo = updateTo;
    }


    public String getCheckboxID() {
        return checkboxID;
    }


    public boolean getUpdateTo() {
        return updateTo;
    }
}
