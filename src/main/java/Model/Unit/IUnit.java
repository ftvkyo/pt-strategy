package Model.Unit;

import Model.Exceptions.NotEnoughPointsException;
import Model.Exceptions.UnitDiedException;
import Model.Item.IItem;

import java.util.ArrayList;

public interface IUnit {
    void restoreAllPoints();
    int getHealthPoints();
    int getMovePoints();
    int getActionPoints();
    int getDamagePoints();

    void changeHealthPoints(int n);
    void changeActionPoints(int n) throws NotEnoughPointsException;
    void changeMovePoints(int n) throws NotEnoughPointsException;
    void setDamagePoints(int n);

    void attackUnit(GenericUnit otherUnit) throws UnitDiedException, NotEnoughPointsException;
    void receiveDamage(GenericUnit attackingUnit) throws UnitDiedException;

    ArrayList<IItem> getInventory();
    void addItem(IItem item);
    void removeItem(int n);

    interface IUnitMaker {
        void createUnit();
        void setOwner();
        GenericUnit getUnit();

        void setHealthPointsMax(int n);
        void setActionPointsMax(int n);
        void setMovePointsMax(int n);
        void setDamagePoints(int n);
    }
}
