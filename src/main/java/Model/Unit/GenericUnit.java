package Model.Unit;

import java.util.ArrayList;

import Model.Exceptions.NotEnoughPointsException;
import Model.Exceptions.UnitDiedException;
import Model.Item.IItem;
import Model.Player;
import com.sun.istack.internal.NotNull;

public class GenericUnit {
    Player owner;

    private ArrayList<IItem> items;
    int healthPointsMax;
    int healthPointsCurrent;
    int actionPointsMax;
    int actionPointsCurrent;
    int movePointsMax;
    int movePointsCurrent;
    int damagePoints;

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

    public void changeHealthPoints(int n) {
        healthPointsCurrent = Math.min(healthPointsCurrent + n, healthPointsMax);
    };

    public int getActionPoints() {
        return actionPointsCurrent;
    }

    public void changeActionPoints(int n) throws NotEnoughPointsException {
        if(actionPointsCurrent + n < 0) {
            throw new NotEnoughPointsException("That unit has not enough Action Points.");
        }
        actionPointsCurrent = Math.min(actionPointsCurrent + n, actionPointsMax);
    }

    public int getMovePoints() {
        return movePointsCurrent;
    }

    public void changeMovePoints(int n) throws NotEnoughPointsException {
        if(movePointsCurrent + n < 0) {
            throw new NotEnoughPointsException("That unit has not enough Move Points.");
        }
        movePointsCurrent = Math.min(movePointsCurrent + n, movePointsMax);
    }

    public void attackUnit(GenericUnit otherUnit) throws UnitDiedException, NotEnoughPointsException {
        if(this.actionPointsCurrent <= 0) {
            throw new NotEnoughPointsException("You cant attack on this turn.");
        }
        this.actionPointsCurrent = 0;
        try {
            otherUnit.recieveDamage(this);
        } catch (UnitDiedException ex) {
            throw new UnitDiedException(otherUnit);
        }
        try {
            this.recieveDamage(otherUnit);
        } catch (UnitDiedException ex) {
            throw new UnitDiedException(this);
        }
    }

    private void recieveDamage(@NotNull GenericUnit attackingUnit) throws UnitDiedException {
        if(this.healthPointsCurrent - attackingUnit.damagePoints <= 0) {
            throw new UnitDiedException();
        }
        this.changeHealthPoints(-attackingUnit.damagePoints);
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

    public class GenericUnitMaker {
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
    }
}
