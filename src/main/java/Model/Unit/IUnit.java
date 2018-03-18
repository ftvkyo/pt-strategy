package Model.Unit;

import Model.Item.GenericItem;

import java.util.ArrayList;


public interface IUnit {
    enum ActionResult { SUCCESS, NOT_ENOUGH_POINTS, DEAD }


    /**
     * Restore value of all possible points to max value.
     */
    void restoreAllPoints();


    /**
     * Change (increase or decrease) amount of Health Points.
     * @param n Positive or negative delta for Health Points
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult changeHealthPoints(int n);


    /**
     * Change (increase or decrease_ amount Action Points.
     * @param n Positive or negative delta for Action Points
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult changeActionPoints(int n);


    /**
     * Getter for Health Points.
     * @return current Health Points amount.
     */
    int getHealthPoints();


    /**
     * Getter for Action Points.
     * @return current Action Points amount.
     */
    int getActionPoints();


    /**
     * Getter for DamagePoints.
     * @return Damage Points amount.
     */
    int getDamagePoints();


    /**
     * Method for attacking other unit
     * @param otherUnit other unit.
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult attackUnit(IUnit otherUnit);


    /**
     * Get inventory of this Unit.
     * @return Inventory
     */
    ArrayList<GenericItem> getItems();


    /**
     * Add item to the inventory of this Unit.
     * @param item Item that will be added.
     */
    void addItem(GenericItem item);


    /**
     * Remove item from this unit inventory.
     * @param n Position (in inventory) of the item that will be removed.
     */
    void removeItem(int n);
}
