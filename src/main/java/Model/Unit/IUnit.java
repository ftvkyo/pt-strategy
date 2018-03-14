package Model.Unit;

import Model.Exceptions.*;
import Model.Item.*;
import java.util.ArrayList;

public interface IUnit {
    ArrayList<IItem> getInventory();
    void addItem(IItem item);
    void removeItem(int n);

    void restoreAllPoints();

    int  getHealthPoints();
    void changeHealthPoints(int n);

    int  getActionPoints();
    void changeActionPoints(int n) throws NotEnoughPointsException;

    int  getMovePoints();
    void changeMovePoints(int n) throws NotEnoughPointsException;

    void attackUnit(IUnit otherUnit);
    //TODO: void death(IUnit unit);
}
