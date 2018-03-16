package Model.Unit;

import java.util.ArrayList;

import Model.Item.IItem;
import Model.Player;

class GenericUnit implements IUnit {
    private Player owner;

    private UnitCondition condition;

    private ArrayList<IItem> items;
    private int healthPointsMax;
    private int healthPointsCurrent;
    private int actionPointsMax;
    private int actionPointsCurrent;
    private int movePointsMax;
    private int movePointsCurrent;
    private int damagePoints;

    private ArrayList<IItem> inventory;

    GenericUnit() {
        inventory = new ArrayList<>();
        condition = UnitCondition.ALIVE;
    }

    void setMaxHealthPoints(int pts) {
        healthPointsMax = pts;
    }

    void setMaxMovePoints(int pts) {
        movePointsMax = pts;
    }

    void setMaxActionPoints(int pts) {
        actionPointsMax = pts;
    }

    void setDamagePoints(int pts) {
        damagePoints = pts;
    }

    public boolean isDead() {
        return condition == UnitCondition.DEAD;
    }

    public void restoreAllPoints() {
        healthPointsCurrent = healthPointsMax;
        actionPointsCurrent = actionPointsMax;
        movePointsCurrent   = movePointsMax;
    }

    public int getHealthPoints() {
        return healthPointsCurrent;
    }

    public int getActionPoints() {
        return actionPointsCurrent;
    }

    public int getMovePoints() {
        return movePointsCurrent;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void changeActionPoints(int n) {
        if(actionPointsCurrent + n < 0) {
            //TODO: return NOT_ENOUGH_POINTS
        }
        actionPointsCurrent = Math.min(actionPointsCurrent + n, actionPointsMax);
    }

    public void changeHealthPoints(int n) {
        healthPointsCurrent = Math.min(healthPointsCurrent + n, healthPointsMax);
    }

    public void changeMovePoints(int n) {
        if(movePointsCurrent + n < 0) {
            //TODO: return NOT_ENOUGH_POINTS
        }
        movePointsCurrent = Math.min(movePointsCurrent + n, movePointsMax);
    }

    public void attackUnit(IUnit otherUnit) {
        if(this.actionPointsCurrent <= 0) {
            //TODO: return NOT_ENOUGH_POINTS
        }
        this.actionPointsCurrent = 0;

        otherUnit.receiveDamage(this.damagePoints);

        if(! otherUnit.isDead()) {
            this.receiveDamage(otherUnit.getDamagePoints());
        }
    }

    public void receiveDamage(int damage) {
        if(this.getHealthPoints() - damage <= 0) {
            this.condition = UnitCondition.DEAD;
        }
        this.changeHealthPoints(-damage);
    }

    public ArrayList<IItem> getInventory() {
        return (ArrayList<IItem>) inventory.clone();
    }

    public void addItem(IItem item) {
        inventory.add(item);
    }

    public void removeItem(int n) {
        inventory.remove(n);
    }

    abstract class GenericUnitMaker {
        GenericUnit unit;

        public void createUnit() {
            unit = new GenericUnit();
        }

        public void setOwner(Player owner) {
            unit.owner = owner;
        }

        abstract void setInventory();

        abstract void setDefaults();

        public GenericUnit getUnit() {
            return unit;
        }
    }
}
