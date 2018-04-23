package Model.Unit;


class CavalryUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new CavalryUnit();
        }


        public void setInventory() {
            //unit.addItem(something);
        }


        public void setDefaults() {
            unit.setDamagePoints(30);
            unit.setMaxHealthPoints(120);
            unit.setMaxActionPoints(14);

            unit.setCanIgnoreCounterAttack(false);

            unit.restoreAllPoints();
        }
    }
}
