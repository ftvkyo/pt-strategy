package Model.Unit;

import java.util.ArrayList;

import Model.Exceptions.NotEnoughPointsException;
import Model.Item.IItem;
import Model.Player;


public class GenericUnit implements IUnit {
    Player owner;

    private ArrayList<IItem> items;
    int healthPointsMax = 100;
    int healthPointsCurrent = 0;
    int actionsPointsCurrent = 0;
    int actionsPointsMax = 0;
    int movePointsMax = 5;
    int movePointsCurrent = 0;
    int attackPoints = 0;

    private ArrayList<IItem> inventory;

    GenericUnit() {
        inventory = new ArrayList<>();
    }

    public void restoreAllPoints() { healthPointsCurrent = healthPointsMax; }

    public int getHealthPoints() { return healthPointsCurrent; }

    public void changeHealthPoints(int n) {
        if (healthPointsCurrent + n <= 0) {
            //TODO: implement death
            //death(this);
        }
        healthPointsCurrent = Math.min(healthPointsCurrent + n, healthPointsMax);
    };

    public int  getActionPoints() { return actionsPointsCurrent; }
    public void changeActionPoints(int n) throws NotEnoughPointsException {
        if (actionsPointsCurrent + n < 0) {
            throw new NotEnoughPointsException();
        }
        actionsPointsCurrent = Math.min(actionsPointsCurrent + n, actionsPointsMax);
    }

    public int  getMovePoints() {
        return movePointsCurrent;
    }
    public void changeMovePoints(int n) throws NotEnoughPointsException {
        if (movePointsCurrent + n < 0) {
            throw new NotEnoughPointsException();
        }
        movePointsCurrent = Math.min(movePointsCurrent + n, movePointsMax);
    }

    public void attackUnit(IUnit otherUnit) {
        if (otherUnit.getHealthPoints() <= this.attackPoints) {
            //TODO: здесь death(otherUnit)
            //death(otherUnit);
        }
        otherUnit.changeHealthPoints(-this.attackPoints);
    }

    public ArrayList<IItem> getInventory() { return (ArrayList<IItem>) inventory.clone(); }
    public void addItem(IItem item) { inventory.add(item); }
    public void removeItem(int n) { inventory.remove(n); }
}
