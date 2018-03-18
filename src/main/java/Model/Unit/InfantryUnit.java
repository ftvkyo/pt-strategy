package Model.Unit;

import Model.Player;


public class InfantryUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {
        public void setInventory() {
            //unit.addItem(something);
        }


        public void setDefaults() {
            unit.setDamagePoints(30);
            unit.setMaxHealthPoints(100);
            unit.setMaxActionPoints(8);

            unit.restoreAllPoints();
        }
    }
}
