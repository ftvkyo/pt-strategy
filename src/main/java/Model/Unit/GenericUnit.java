package Model.Unit;

import Model.Item.GenericItem;
import Model.Player.Player;
import Model.Unit.UnitAction.Action;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * GenericUnit class for all units.
 * Just like IUnit interface but with package-private and private members,
 * not intended to be used not from package.
 *
 * Particularly methods for correct implementation of Builder Design Pattern.
 * It means that some fields of object will not be editable outside the package, for example
 * maximal values of *Points and damage of the Unit.
 */
class GenericUnit implements IUnit {

    /**
     * Owner of the Unit.
     */
    Player owner;


    /**
     * Maximal possible value of Health Points of the Unit.
     */
    int healthPointsMax;


    /**
     * Current value of Health Points of the Unit.
     */
    private int healthPointsCurrent;


    /**
     * Maximal possible value of GenericAction Points of the Unit.
     */
    int actionPointsMax;


    /**
     * Current value of GenericAction Points of the Unit.
     */
    private int actionPointsCurrent;


    /**
     * Damage that the Unit does to other units during attack.
     */
    int damagePoints;


    /**
     * Determines if unit is able to ignore incoming attack right after its attack.
     */
    boolean canIgnoreCounterAttack;


    /**
     * Inventory of the Unit.
     */
    private final ArrayList<GenericItem> items = new ArrayList<>();


    /**
     * Available actions.
     */
    final HashSet<Action> availableActions = new HashSet<>();


    /**
     * Default Constructor.
     */
    public GenericUnit() {}


    public boolean getCanIgnoreCounterAttack() {
        return canIgnoreCounterAttack;
    }


    public void restoreAllPoints() {
        healthPointsCurrent = healthPointsMax;
        actionPointsCurrent = actionPointsMax;
    }


    public void restoreActionPoints() {
        actionPointsCurrent = actionPointsMax;
    }


    public int getHealthPoints() {
        return healthPointsCurrent;
    }


    public int getActionPoints() {
        return actionPointsCurrent;
    }


    public int getDamagePoints() {
        return damagePoints;
    }


    public void changeActionPoints(int delta) {
        actionPointsCurrent = Math.max(0, Math.min(actionPointsCurrent + delta, actionPointsMax));
    }


    public void changeHealthPoints(int delta) {
        healthPointsCurrent = Math.max(0, Math.min(healthPointsCurrent + delta, healthPointsMax));
    }


    public void zeroActionPoints() {
        actionPointsCurrent = 0;
    }


    public void zeroHealthPoints() {
        actionPointsCurrent = 0;
    }


    public ArrayList<GenericItem> getItems() {
        return new ArrayList<>(items);
    }


    public void addItem(GenericItem item) {
        items.add(item);
    }


    public void removeItem(int n) {
        items.remove(n);
    }


    //TODO: Добавить проверку по-другому (передавать action и проверять, доступно ли оно)
    public HashSet<Action> getAvailableActions() {
        return new HashSet<>(availableActions);
    }


    /**
     * Part of Builder Design Pattern.
     * "Creator and initializer" of Units.
     * Must be used in UnitBuilder Class.
     *
     * createUnit() and getUnit() methods should be called only once through the unit creation.
     */
    static abstract class GenericUnitMaker {

        /**
         * Container of the unit.
         */
        GenericUnit unit;


        /**
         * First method to be called in the UnitBuilder class.
         */
        abstract void createUnit();


        /**
         * Set owner of current unit in the container.
         * @param owner Owner of the unit.
         */
        public void setOwner(Player owner) {
            unit.owner = owner;
        }


        /**
         * Sets default Inventory for every type of Unit.
         */
        abstract void setInventory();


        /**
         * Sets default parameters for every type of Unit.
         */
        abstract void setDefaults();


        /**
         * Sets available actions for every type of Unit.
         */
        abstract void setActions();


        /**
         * Getter of the unit.
         * @return Created Unit.
         */
        public GenericUnit getUnit() {
            return unit;
        }
    }
}
