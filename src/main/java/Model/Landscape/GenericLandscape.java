package Model.Landscape;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

import java.util.ArrayList;

abstract public class GenericLandscape {

    /**
     * GenericAction Points needed to step on this Landscape.
     */
    private int passableness;


    /**
     * Unit on current Landscape.
     */
    private IUnit unit;


    /**
     * Items on current Landscape.
     */
    private ArrayList<GenericItem> items;


    /**
     * Setter for passableness of Landscape.
     * @param p Positive delta for passableness of Landscape
     */
    void setPassableness(int p) {
        passableness = p;
    }


    /**
     * Getter for passableness of Landscape.
     * @return passableness of Landscape
     */
    public int getPassableness() {
        return passableness;
    }


    /**
     * Method for putting Unit on this Landscape.
     * @param un Unit to put on this Landscape
     */
    public void setUnit(IUnit un) {
        this.unit = un;
    }


    /**
     * Method for getting Unit on this Landscape.
     * @return Unit on this Landscape
     */
    public IUnit getUnit() {
        return this.unit;
    }


    /**
     * Method for swapping Units (on this Landscape and on Landscape l).
     * @param l second Landscape for swapping Units
     */
    public void swapUnit(GenericLandscape l) {
        IUnit tmp = l.getUnit();
        l.setUnit(this.getUnit());
        this.setUnit(tmp);
    }


    /**
     * Method to add Item on this Landscape.
     * @param item Item to put on this Landscape
     */
    public void addItem(GenericItem item) {
        items.add(item);
    }


    /**
     * Method for getting Items on this Landscape.
     * @return copy of the inventory of the Unit
     */
    public ArrayList<GenericItem> getItems() {
        return (ArrayList<GenericItem>) items.clone();
    }


    /**
     * Method to remove n-th Item from this Landscape.
     * @param n number of the Item to remove
     */
    public void removeItem(int n) {
        items.remove(n);
    }


    /**
     * Class for Factory Method Design Pattern.
     */
    abstract public static class GenericLandscapeFactory {

        /**
         * Factory method.
         * @return newly generated Landscape object
         */
        abstract public GenericLandscape createInstance();
    }
}
