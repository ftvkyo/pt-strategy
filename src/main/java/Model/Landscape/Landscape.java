package Model.Landscape;

import Model.Item.IItem;
import Model.Unit.IUnit;
import Model.Landscape.ILandscape;

import java.util.ArrayList;

public class Landscape {
    //TYPES : free, mountain, item
    private String type;
    //CONDITIONS : free (of unit) or occupied
    private ILandscape.LandscapeCondition condition;
    private IUnit unit;
    private ArrayList<IItem> inventory;


    void addUnit(IUnit un) {
        if (this.condition == ILandscape.LandscapeCondition.FREE) {
            unit = un;
        }
    }
    void addItem(IItem item) {
        inventory.add(item);
    }


    public String getType() { return type; }
    public IUnit getUnit() {
        if (this.condition == ILandscape.LandscapeCondition.OCCUPIED) {
            return unit;
        }
        return null;
    }
}
