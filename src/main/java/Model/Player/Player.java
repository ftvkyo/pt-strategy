package Model.Player;

import Model.Unit.IUnit;
import java.util.ArrayList;

/**
 * TODO: doc
 */
public class Player {
    private UnitGroup selectedUnits; //TODO: init

    /**
     * Allows Player to group his Units to perform actions on them.
     * Structure pattern Facade.
     */
    public class UnitGroup {
        private ArrayList<IUnit> units; //TODO: init

        public void addUnit(IUnit unit) {
            units.add(unit);
        }

        public void clearUnits() {
            units.clear();
        }

        public void performAction(IUnit.Action action) {
            for(IUnit unit : units) {
                unit.performAction(action);
            }
        }
    }
}
