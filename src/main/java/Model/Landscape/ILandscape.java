package Model.Landscape;

import Model.Item.IItem;
import Model.Unit.IUnit;


import java.util.ArrayList;

public interface ILandscape {
    //Здесь содержится интерфеис всякой хрени, которая может встретиться на игровом поле

    enum LandscapeCondition { FREE, OCCUPIED }
    void addUnit(IUnit un);
    void addItem(IItem item);

    String getType();
    IUnit getUnit();
    ArrayList<IItem> getInventory();
    //createMountain
}
