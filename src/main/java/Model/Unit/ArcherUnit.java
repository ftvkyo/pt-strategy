package Model.Unit;

import Model.Player;


class ArcherUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {
        public void setInventory() {
            //unit.addItem(something);
        }


        public void setDefaults() {
            unit.setDamagePoints(20);
            unit.setMaxHealthPoints(70);
            unit.setMaxActionPoints(10);

            unit.restoreAllPoints();
        }
    }
}
