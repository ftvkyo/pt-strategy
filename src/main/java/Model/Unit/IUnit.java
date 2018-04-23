package Model.Unit;

import Model.Item.GenericItem;

import java.util.ArrayList;

/**
 * Interface of units. Should be used everywhere, where it's possible instead of GenericUnit class.
 */
public interface IUnit {
    /**
     * Пока что особенностью Action-ов является их ограниченность,
     * например, если мы хотим все действия юнитов переписать на Actions,
     * то потребуется довольно сильная их переработка, потому что у разных
     * действий будут разные требования, например проверка дальности до цели,
     * если реализовывать атаку других юнитов через Actions.
     * TODO?: transform Actions to more complex structure
     */
    enum Action { EXAMPLE_ACTION, ONLY_UPGRADED_ACTION, SIMPLE_ACTION }
    enum ActionResult { SUCCESS, NOT_ENOUGH_POINTS, UNIT_DIED, ACTION_UNAVAILABLE }
    enum AttackResult { NOBODY_DIED, ATTACKER_DIED, DEFENDER_DIED }


    /**
     * Restore value of all possible points to max value.
     */
    void restoreAllPoints();


    /**
     * Restore value of Action Points.
     */
    void restoreActionPoints();


    /**
     * Change (increase or decrease) amount of Health Points.
     * @param n Positive or negative delta for changing Health Points
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult changeHealthPoints(int n);


    /**
     * Change (increase or decrease) amount of Action Points.
     * @param n Positive or negative delta for changing Action Points
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult changeActionPoints(int n);


    /**
     * Getter for Health Points.
     * @return current Health Points amount
     */
    int getHealthPoints();


    /**
     * Getter for Action Points.
     * @return current Action Points amount
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
     * Method for attacking other unit
     * @param otherUnit other unit.
     * @return AttackResult.NOBODY_DIED or AttackResult.ATTACKER_DIED or AttackResult.DEFENDER_DIED
     */
    AttackResult attackUnit(IUnit otherUnit);


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


    /**
     * Perform action on this unit.
     * @param action Action to be performed
     */
    ActionResult performAction(Action action);
}
