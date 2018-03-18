package Model.Landscape;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

import java.util.ArrayList;

abstract public class GenericLandscape {

    /**
     * Action Points to move to this Landscape
     */
    private int passableness;


    private IUnit unit;


    private ArrayList<GenericItem> items;


    void setPassableness(int p) {
        passableness = p;
    }


    public int getPassableness() {
        return passableness;
    }


    public void setUnit(IUnit un) {
        this.unit = un;
    }


    public IUnit getUnit() {
        return this.unit;
    }


    public void swapUnit(GenericLandscape l) {
        IUnit tmp = l.getUnit();
        l.setUnit(this.getUnit());
        this.setUnit(tmp);
    }


    public void addItem(GenericItem item) {
        items.add(item);
    }


    public ArrayList<GenericItem> getItems() {
        return (ArrayList<GenericItem>) items.clone();
    }


    public void removeItem(int n) {
        items.remove(n);
    }


    abstract public static class GenericLandscapeFactory {

        abstract public GenericLandscape createInstance();
    }
}
