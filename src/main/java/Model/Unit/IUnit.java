package Model.Unit;

import Model.Item.GenericItem;
import Model.Unit.UnitAction.Action;

import java.util.ArrayList;

/**
 * Interface of units. Should be used everywhere, where it's possible instead of GenericUnit class.
 */
public interface IUnit {

    /**
     * Restore value of all possible points to max value.
     */
    void restoreAllPoints();


    /**
     * Restore value of GenericAction Points.
     */
    void restoreActionPoints();


    /**
     * Change (increase or decrease) amount of Health Points.
     * @param delta Positive or negative delta for changing Health Points
     */
    void changeHealthPoints(int delta);


    /**
     * Change (increase or decrease) amount of GenericAction Points.
     * @param delta Positive or negative delta for changing GenericAction Points
     */
    void changeActionPoints(int delta);


    /**
     * Sets action points to zero.
     * Useful for attacks (just like in Sid Meier's Civilization)
     */
    void zeroActionPoints();


    /**
     * Sets health points to zero.
     */
    void zeroHealthPoints();


    /**
     * Getter for Health Points.
     * @return current Health Points amount
     */
    int getHealthPoints();


    /**
     * Getter for GenericAction Points.
     * @return current GenericAction Points amount
     */
    int getActionPoints();


    /**
     * Getter for DamagePoints.
     * @return Damage Points amount
     */
    int getDamagePoints();


    /**
     * Some units are able to ignore incoming attack after their attack,
     * this is determined by this getter.
     * @return true if the unit can ignore counter attack, false otherwise.
     */
    boolean getCanIgnoreCounterAttack();


    /**
     * Get inventory of this Unit.
     * @return Inventory
     */
    ArrayList<GenericItem> getItems();


    /**
     * Add item to the inventory of this Unit.
     * @param item Item that will be added
     */
    void addItem(GenericItem item);


    /**
     * Remove item from this unit inventory.
     * @param n Position (in inventory) of the item that will be removed
     */
    void removeItem(int n);


    /**
     * Get available actions for this Unit
     * @return list of available actions
     */
    ArrayList<Action> getAvailableActions();
}
