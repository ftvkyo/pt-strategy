package Model.Unit;

import java.util.ArrayList;

import Model.Item.GenericItem;
import Model.Player.Player;


/**
 * Generic class for all units.
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
     * Damage that the Unit does to other units during attack.
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
     * Available actions.
     * TODO: ArrayList -> Set
     */
    //package protected
    ArrayList<Action> availableActions;


    /**
     * Default Constructor.
     */
    GenericUnit() {
        items = new ArrayList<>();
    }


    public boolean getCanIgnoreCounterAttack() {
        return canIgnoreCounterAttack;
    }


    /**
     * //TODO
     * @param canIgnoreCounterAttack true if the unit can ignore counter attack, false otherwise.
     */
    void setCanIgnoreCounterAttack(boolean canIgnoreCounterAttack) {
        this.canIgnoreCounterAttack = canIgnoreCounterAttack;
    }


    /**
     * Change maximum value of Health Points.
     * @param maxHealthPoints New maximum value for Health Points
     */
    void setMaxHealthPoints(int maxHealthPoints) {
        healthPointsMax = maxHealthPoints;
    }


    /**
     * Change maximum value of Action Points
     * @param maxActionPoints New maximum value for Action Points
     */
    void setMaxActionPoints(int maxActionPoints) {
        actionPointsMax = maxActionPoints;
    }


    /**
     * Change maximum value of Damage Points
     * @param damagePoints New maximum value for Damage Points
     */
    void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
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


    public ActionResult changeActionPoints(int n) {
        if(actionPointsCurrent + n < 0) {
            return ActionResult.NOT_ENOUGH_POINTS;
        }
        actionPointsCurrent = Math.min(actionPointsCurrent + n, actionPointsMax);
        return ActionResult.SUCCESS;
    }


    public ActionResult changeHealthPoints(int n) {
        ActionResult retval = ActionResult.SUCCESS;
        if(healthPointsCurrent + n <= 0) {
            retval = ActionResult.UNIT_DIED;
        }
        healthPointsCurrent = Math.min(Math.max(healthPointsCurrent + n, 0), healthPointsMax);
        return retval;
    }


    /**
     * Estimate whether Unit is able to attack
     * @return ActionResult.SUCCESS or ActionResult.NOT_ENOUGH_POINTS
     */
    ActionResult ableToAttack() {
        if(this.actionPointsCurrent <= 0) {
            return ActionResult.NOT_ENOUGH_POINTS;
        }
        return ActionResult.SUCCESS;
    }


    public AttackResult attackUnit(IUnit otherUnit) {
        if(this.ableToAttack() == ActionResult.NOT_ENOUGH_POINTS) {
            return AttackResult.NOBODY_DIED;
        } else {
            this.actionPointsCurrent = 0;

            ActionResult outcomingAttackResult = otherUnit.changeHealthPoints(-this.damagePoints);

            if(outcomingAttackResult == ActionResult.UNIT_DIED) {
                return AttackResult.DEFENDER_DIED;
            }

            if(!this.canIgnoreCounterAttack) {
                ActionResult incomingAttackResult = this.changeHealthPoints(-otherUnit.getDamagePoints());
                if(incomingAttackResult == ActionResult.UNIT_DIED) {
                    return AttackResult.ATTACKER_DIED;
                }
            }

            return AttackResult.NOBODY_DIED;
        }
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


    public ArrayList<Action> getAvailableActions() {
        return (ArrayList<Action>) availableActions.clone();
    }

    public ActionResult performAction(Action action) {
        /*TODO*/
        return ActionResult.SUCCESS;
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
