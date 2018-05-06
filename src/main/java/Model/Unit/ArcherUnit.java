package Model.Unit;


public class ArcherUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new ArcherUnit();
        }


        public void setInventory() {
        }


        public void setDefaults() {
            unit.damagePoints = 20;
            unit.healthPointsMax = 70;
            unit.actionPointsMax = 10;

            unit.canIgnoreCounterAttack = true;

            unit.restoreAllPoints();
        }


        public void setActions() {
            unit.availableActions.add(Action.SIMPLE_ACTION);

        }
    }
}
