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

        /**
         * Current group of Units.
         */
        private ArrayList<IUnit> units = new ArrayList<>();

        /**
         * Add unit into the group.
         * @param unit The unit to be added
         */
        public void addUnit(IUnit unit) {
            units.add(unit);
        }

        /**
         * Clear current group of Units.
         */
        public void clearUnits() {
            units.clear();
        }

        /**
         * Perform action on all Units in group.
         * @param action Action to be performed
         */
        public void performAction(IUnit.Action action) {
            for(IUnit unit : units) {
                unit.performAction(action);
            }
        }
    }
}
