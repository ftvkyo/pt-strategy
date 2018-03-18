package Model.Landscape;

import Model.Item.IItem;
import Model.Unit.IUnit;


import java.util.ArrayList;

public interface ILandscape {
    enum Type { PLAIN, FOREST, MOUNTAIN }


    void setUnit(IUnit un);


    IUnit getUnit();


    void moveUnit(ILandscape l);


    void addItem(IItem item);


    ArrayList<IItem> getItems();


    void removeItem(int n);
}
