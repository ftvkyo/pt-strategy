package Model.Landscape;

import Model.Item.IItem;
import Model.Unit.IUnit;

import java.util.ArrayList;

public class Landscape implements ILandscape {

    Type type;


    private IUnit unit;


    private ArrayList<IItem> items;


    public void setUnit(IUnit un) {
        this.unit = un;
    }


    public IUnit getUnit() {
        return this.unit;
    }


    public void moveUnit(ILandscape l) {
        l.setUnit(this.unit);
        this.unit = null;
    }


    public void addItem(IItem item) {
        items.add(item);
    }


    public ArrayList<IItem> getItems() {
        return (ArrayList<IItem>) items.clone();
    }


    public void removeItem(int n) {
        items.remove(n);
    }
}
