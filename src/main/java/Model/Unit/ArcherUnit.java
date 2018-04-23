package Model.Unit;


class ArcherUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new ArcherUnit();
        }


        public void setInventory() {
        }


        public void setDefaults() {
            unit.setDamagePoints(20);
            unit.setMaxHealthPoints(70);
            unit.setMaxActionPoints(10);

            unit.setCanIgnoreCounterAttack(true);

            unit.restoreAllPoints();
        }
    }
}
