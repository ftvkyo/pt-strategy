package Model.Unit;

import java.util.ArrayList;

import Model.Item.GenericItem;
import Model.Player;


/**
 * Generic class for all units.
 * Just like IUnit interface but with package-private and private members,
 * not intended to be used not from package.
 *
 * Particularly methods for correct implementation of Builder Design Pattern.
 * It means, that some fields of object will not be editable outside the package, for example
 * maximal values of *Points and damage of the unit.
 */
class GenericUnit implements IUnit {

    /**
     * Owner of the Unit.
     */
    private Player owner;


    /**
     * Maximal possible value of Health Points of the Unit.
     */
    private int healthPointsMax;


    /**
     * Current value of Health Points of the Unit.
     */
    private int healthPointsCurrent;


    /**
     * Maximal possible value of Action Points of the Unit.
     */
    private int actionPointsMax;


    /**
     * Current value of Action Points of the Unit.
     */
    private int actionPointsCurrent;


    /**
     * Damage that the Unit deal to other units during attack.
     */
    private int damagePoints;


    /**
     * Determines if unit is able to ignore incoming attack right after its attack.
     */
    private boolean canIgnoreCounterAttack;


    /**
     * Inventory of the Unit.
     */
    private ArrayList<GenericItem> items;


    /**
     * Default Constructor.
     */
    GenericUnit() {
        items = new ArrayList<>();
    }


    /**
     * Change maximum value of Health Points.
     * @param pts New maximum value for Health Points
     */
    void setMaxHealthPoints(int pts) {
        healthPointsMax = pts;
    }


    /**
     * Change maximum value of Action Points
     * @param pts New maximum value for Action Points
     */
    void setMaxActionPoints(int pts) {
        actionPointsMax = pts;
    }


    /**
     * Change maximum value of Damage Points
     * @param pts New maximum value for Damage Points
     */
    void setDamagePoints(int pts) {
        damagePoints = pts;
    }


    public void restoreAllPoints() {
        healthPointsCurrent = healthPointsMax;
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


    public ActionResult changeActionPoints(int n) {
        if(actionPointsCurrent + n < 0) {
            return ActionResult.NOT_ENOUGH_POINTS;
        }
        actionPointsCurrent = Math.min(actionPointsCurrent + n, actionPointsMax);
        return ActionResult.SUCCESS;
    }


    public ActionResult changeHealthPoints(int n) {
        if(healthPointsCurrent + n < 0) {
            return ActionResult.DEAD;
        }
        healthPointsCurrent = Math.min(Math.max(healthPointsCurrent + n, 0), healthPointsMax);
        return ActionResult.SUCCESS;
    }


    public ActionResult attackUnit(IUnit otherUnit) {
        if(this.actionPointsCurrent <= 0) {
            return ActionResult.NOT_ENOUGH_POINTS;
        }
        this.actionPointsCurrent = 0;

        ActionResult firstAttackResult = otherUnit.changeHealthPoints(-this.damagePoints);

        if((firstAttackResult != ActionResult.DEAD) || this.canIgnoreCounterAttack) {
            this.changeHealthPoints(-otherUnit.getDamagePoints());
        }
        return ActionResult.SUCCESS;
    }


    public ArrayList<GenericItem> getItems() {
        return (ArrayList<GenericItem>) items.clone();
    }


    public void addItem(GenericItem item) {
        items.add(item);
    }


    public void removeItem(int n) {
        items.remove(n);
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
         * Getter of the unit.
         * @return Created Unit.
         */
        public GenericUnit getUnit() {
            return unit;
        }
    }
}