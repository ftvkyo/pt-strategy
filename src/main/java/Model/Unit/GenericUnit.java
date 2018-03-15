package Model.Unit;

import java.util.ArrayList;

import Model.Exceptions.NotEnoughPointsException;
import Model.Exceptions.UnitDiedException;
import Model.Item.IItem;
import Model.Player;
import com.sun.istack.internal.NotNull;

public class GenericUnit implements IUnit{
    Player owner;

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
    }

    public void restoreAllPoints() {
        healthPointsCurrent = healthPointsMax;
        actionPointsCurrent = actionPointsMax;
        movePointsCurrent = movePointsMax;
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

    public void changeActionPoints(int n) throws NotEnoughPointsException {
        if(actionPointsCurrent + n < 0) {
            throw new NotEnoughPointsException("That unit has not enough Action Points.");
        }
        actionPointsCurrent = Math.min(actionPointsCurrent + n, actionPointsMax);
    }

    public void changeHealthPoints(int n) {
        healthPointsCurrent = Math.min(healthPointsCurrent + n, healthPointsMax);
    }

    public void changeMovePoints(int n) throws NotEnoughPointsException {
        if(movePointsCurrent + n < 0) {
            throw new NotEnoughPointsException("That unit has not enough Move Points.");
        }
        movePointsCurrent = Math.min(movePointsCurrent + n, movePointsMax);
    }

    public void setDamagePoints(int n) {
        this.damagePoints = n;
    }

    public void attackUnit(GenericUnit otherUnit) throws UnitDiedException, NotEnoughPointsException {
        if(this.actionPointsCurrent <= 0) {
            throw new NotEnoughPointsException("You cant attack on this turn.");
        }
        this.actionPointsCurrent = 0;
        try {
            otherUnit.receiveDamage(this);
        } catch (UnitDiedException ex) {
            throw new UnitDiedException(otherUnit);
        }
        try {
            this.receiveDamage(otherUnit);
        } catch (UnitDiedException ex) {
            throw new UnitDiedException(this);
        }
    }

    public void receiveDamage(@NotNull GenericUnit attackingUnit) throws UnitDiedException {
        if(this.getHealthPoints() - attackingUnit.getDamagePoints() <= 0) {
            throw new UnitDiedException();
        }
        this.changeHealthPoints(-attackingUnit.getDamagePoints());
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

    public class GenericUnitMaker implements IUnitMaker {
        Player owner;
        GenericUnit unit;

        public GenericUnitMaker(Player owner) {
            this.owner = owner;
        }

        public void createUnit() {
            unit = new GenericUnit();
        }

        public void setOwner() {
            unit.owner = this.owner;
        }

        public GenericUnit getUnit() {
            return unit;
        }

        public void setHealthPointsMax(int n) {
            healthPointsMax = n;
        }
        public void setActionPointsMax(int n) {
            actionPointsMax = n;
        }
        public void setMovePointsMax(int n) {
            movePointsMax = n;
        }
        public void setDamagePoints(int n) {
            damagePoints = n;
        }
    }
}
