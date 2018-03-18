package Model.Landscape;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

import java.util.ArrayList;

abstract public class GenericLandscape {

    /**
     * Action Points to move to this Landscape
     */
    private int passableness;


    /**
     *
     */
    private IUnit unit;


    /**
     *
     */
    private ArrayList<GenericItem> items;


    /**
     *
     * @param p
     */
    void setPassableness(int p) {
        passableness = p;
    }


    /**
     *
     * @return
     */
    public int getPassableness() {
        return passableness;
    }


    /**
     *
     * @param un
     */
    public void setUnit(IUnit un) {
        this.unit = un;
    }


    /**
     *
     * @return
     */
    public IUnit getUnit() {
        return this.unit;
    }


    /**
     *
     * @param l
     */
    public void swapUnit(GenericLandscape l) {
        IUnit tmp = l.getUnit();
        l.setUnit(this.getUnit());
        this.setUnit(tmp);
    }


    /**
     *
     * @param item
     */
    public void addItem(GenericItem item) {
        items.add(item);
    }


    /**
     *
     * @return
     */
    public ArrayList<GenericItem> getItems() {
        return (ArrayList<GenericItem>) items.clone();
    }


    /**
     *
     * @param n
     */
    public void removeItem(int n) {
        items.remove(n);
    }


    /**
     *
     */
    abstract public static class GenericLandscapeFactory {

        /**
         *
         * @return
         */
        abstract public GenericLandscape createInstance();
    }
}
