package Model.Unit;


public class InfantryUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new InfantryUnit();
        }


        public void setInventory() {
        }


        public void setDefaults() {
            unit.damagePoints = 30;
            unit.healthPointsMax = 100;
            unit.actionPointsMax = 8;

            unit.canIgnoreCounterAttack = false;

            unit.restoreAllPoints();
        }


        public void setActions() {
            unit.availableActions.add(Action.SIMPLE_ACTION);
        }
    }
}
