package View.Notification;

import java.util.ArrayList;


public class FieldUpdate implements INotification {

    private int row, col;
    private ArrayList<String> contents;


    public FieldUpdate(int row, int col, ArrayList<String> contents) {
        this.row = row;
        this.col = col;
        this.contents = new ArrayList<>(contents);
    }


    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }


    public ArrayList<String> getContents() {
        return new ArrayList<>(contents);
    }
}
