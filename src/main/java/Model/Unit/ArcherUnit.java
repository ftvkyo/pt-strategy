package Model.Unit;


import Model.Unit.UnitAction.AttackAction;
import Model.Unit.UnitAction.OnlyArcherAction;
import Model.Unit.UnitAction.SimpleAction;


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
            unit.availableActions.add(SimpleAction.instance);
            unit.availableActions.add(AttackAction.instance);
            unit.availableActions.add(OnlyArcherAction.instance);
        }
    }
}
