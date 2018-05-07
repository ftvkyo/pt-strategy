package Model.Unit;

import Model.Unit.UnitAction.IAction;

import java.util.ArrayList;

public class UnitGroup {

        /**
         * Текущая группа Units.
         */
        private final ArrayList<IUnit> units = new ArrayList<>();


        /**
         * Метод для добавления Unit'a в текущую группу.
         * @param unit Unit, который будет добавлен
         */
        public void addUnit(IUnit unit) {
            units.add(unit);
        }


        /**
         * Метод для удаления всех Unit'ов из текущей группы.
         */
        public void clearUnits() {
            units.clear();
        }


        /**
         * Метод для совершения IAction текущей группой.
         * Возможность совершить IAction этой группой
         * должна быть проверена извне методом canPerformAction.
         * @param action действие, которое должно быть выполнено
         * @return Количество неудачных попыток выполнить действие
         * (Действие может не выполниться, если, например,
         * группа Units атакует другого Unit'a, и он умирает до того,
         * как все Units группы его атаковали)
         */
        public int performAction(IAction action) {
            int fails = 0;
            for(IUnit unit : units) {
                IAction.ActionResult result = action.perform(unit, null, null);
                if(result == IAction.ActionResult.FAIL) {
                    fails += 1;
                }
            }
            return fails;
        }


        /**
         * Проверяет, все ли юниты могут выполнить это действие.
         * @param action действие, которые мы выполняем
         * @return Способность всех Units группы выполнить данное действие
         */
        public boolean canPerformAction(IAction action) {
            for(IUnit unit : units) {
                if(!action.canPerform(unit)) {
                    return false;
                }
            }
            return true;
        }
    }
