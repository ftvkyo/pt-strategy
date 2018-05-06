package Model.Player;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;

import java.util.ArrayList;

/**
 * Обычный класс игрока, который отвеает за действия от его имени
 */
public class Player {
    private UnitGroup selectedUnits = new UnitGroup();

    /**
     * Allows Player to group his Units to perform actions on them.
     * Structure pattern Facade.
     */
    public static class UnitGroup {

        /**
         * Current group of Units.
         */
        private final ArrayList<IUnit> units = new ArrayList<>();


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
         * Perform action on all Units in group.]
         * Возможность совершить action этой группой юнитов
         * должна быть проверена извне методом canPerformAction.
         * @param action GenericAction to be performed
         * @return Количество неудачных action.
         */
        public int performAction(Action action) {
            int fails = 0;
            for(IUnit unit : units) {
                Action.ActionResult result = action.perform(unit, null, null);
                if(result == Action.ActionResult.FAIL) {
                    fails += 1;
                }
            }
            return fails;
        }


        /**
         * Проверяет, все ли юниты могут выполнить это действие.
         * @param action Action, который мы выполняем
         * @return Количество неудавшихся выполнений
         */
        public boolean canPerformAction(Action action) {
            for(IUnit unit : units) {
                if(!action.canPerform(unit)) {
                    return false;
                }
            }
            return true;
        }
    }
}
