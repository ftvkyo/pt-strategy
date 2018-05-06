package Model.Unit;


import Model.Unit.UnitAction.AttackAction;
import Model.Unit.UnitAction.SimpleAction;

public class CavalryUnit extends GenericUnit {

    static public class UnitMaker extends GenericUnit.GenericUnitMaker {

        public void createUnit() {
            unit = new CavalryUnit();
        }


        public void setInventory() {
        }


        public void setDefaults() {
            unit.damagePoints = 30;
            unit.healthPointsMax = 120;
            unit.actionPointsMax = 14;

            unit.canIgnoreCounterAttack = false;

            unit.restoreAllPoints();
        }


        public void setActions() {
            unit.availableActions.add(SimpleAction.getAction());
            unit.availableActions.add(AttackAction.getAction());
        }
    }
}
