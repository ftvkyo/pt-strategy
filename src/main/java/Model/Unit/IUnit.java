package Model.Unit;

import Model.Item.IItem;

import java.util.ArrayList;

public interface IUnit {
    enum UnitCondition { ALIVE, DEAD }

    boolean isDead();

    void restoreAllPoints();
    void changeHealthPoints(int n);
    void changeActionPoints(int n);

    int  getHealthPoints();
    int  getActionPoints();
    int  getDamagePoints();

    void attackUnit(IUnit otherUnit);
    void receiveDamage(int damage);

    ArrayList<IItem> getInventory();
    void addItem(IItem item);
    void removeItem(int n);
}
