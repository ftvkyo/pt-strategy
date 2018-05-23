package Model;

import View.Notification.CheckboxUpdate;
import View.Notification.FieldUpdate;
import View.Notification.INotificationReceiver;
import View.Notification.WindowChange;

import java.util.ArrayList;


public class Model {

    private INotificationReceiver receiver;

    private Field field = new Field();

    private boolean exampleCheckboxState = false;


    public Model() {
        reset();
    }


    public void setReceiver(INotificationReceiver receiver) {
        this.receiver = receiver;
    }


    public void beginGame() {
        for(int i = 0; i < field.fieldSize; i++) {
            for(int j = 0; j < field.fieldSize; j++) {
                updateFieldCell(i, j);
            }
        }

        receiver.receiveNotification(WindowChange.SWITCH_TO_GAME);
    }


    public void pauseOrExit() {
        receiver.receiveNotification(WindowChange.SWITCH_TO_SETTINGS_OR_EXIT);
    }


    public void reset() {
        field.reset();
    }


    public void toggleExampleCheckbox() {
        exampleCheckboxState = !exampleCheckboxState;
        receiver.receiveNotification(new CheckboxUpdate("example-checkbox", exampleCheckboxState));
    }


    public void updateFieldCell(int row, int col) {
        ArrayList<String> cellContents = field.getCellContents(row, col);
        receiver.receiveNotification(new FieldUpdate(row, col, cellContents));

        /*
        System.err.print(row);
        System.err.print(" ");
        System.err.print(col);
        System.err.print(" ");
        System.err.println(cellContents);
        */
    }
}
