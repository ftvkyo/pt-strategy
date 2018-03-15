package Model.Unit;

import Model.Exceptions.NotEnoughPointsException;
import Model.Exceptions.UnitDiedException;
import Model.Item.IItem;

import java.util.ArrayList;

public interface IUnit {
    void restoreAllPoints();
    int getHealthPoints();
    void changeHealthPoints(int n);
    int getActionPoints();
    void changeActionPoints(int n) throws NotEnoughPointsException;
    int getMovePoints();
    void changeMovePoints(int n) throws NotEnoughPointsException;
    void attackUnit(GenericUnit otherUnit) throws UnitDiedException, NotEnoughPointsException;
    void receiveDamage(GenericUnit attackingUnit) throws UnitDiedException;
    ArrayList<IItem> getInventory();
    void addItem(IItem item);
    void removeItem(int n);
}
