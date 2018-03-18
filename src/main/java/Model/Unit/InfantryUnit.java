package Model.Unit;

import Model.Player;


class InfantryUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new InfantryUnit();
        }


        public void setInventory() {
            //unit.addItem(something);
        }


        public void setDefaults() {
            unit.setDamagePoints(30);
            unit.setMaxHealthPoints(100);
            unit.setMaxActionPoints(8);

            unit.setCanIgnoreCounterAttack(false);

            unit.restoreAllPoints();
        }
    }
}
