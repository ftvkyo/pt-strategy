package Model.Player;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;

import java.util.ArrayList;

/**
 * Обычный класс игрока, который отвечает за действия от его имени.
 */
public class Player {
    private UnitGroup selectedUnits = new UnitGroup();

    /**
     * Позволяет игроку группировать свои Unit'ы для выполнения действий над ними.
     * Структурный паттерн Facade.
     */
    public static class UnitGroup {

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
         * Метод для совершения Action текущей группой.
         * Возможность совершить Action этой группой
         * должна быть проверена извне методом canPerformAction.
         * @param action действие, которое должно быть выполнено
         * @return Количество неудачных попыток выполнить действие
         * (Действие может не выполниться, если, например,
         * группа Units атакует другого Unit'a, и он умирает до того,
         * как все Units группы его атаковали)
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
         * @param action действие, которые мы выполняем
         * @return Способность всех Units группы выполнить данное действие
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
