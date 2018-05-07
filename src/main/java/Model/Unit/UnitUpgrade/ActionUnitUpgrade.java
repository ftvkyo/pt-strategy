package Model.Unit.UnitUpgrade;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;

import java.util.HashSet;

public class ActionUnitUpgrade extends GenericUnitUpgrade {

    /**
     * Множество действий, которые мы осуществляем внутри декоратора. (?)
     * Set of actions, that we process inside of decorator.
     */
    private final HashSet<Action> availableActions = new HashSet<>();


    /**
     * Процесс улучшения Unit'a.
     * TODO: Should I implement it as constructor?
     * @param unit юнит, который будет улучшен
     * @param actions действие, возможность совершать которое получит этот Unit
     * @return Улучшенный Unit
     */
    public static GenericUnitUpgrade upgradeUnit(IUnit unit, HashSet<Action> actions) {
        ActionUnitUpgrade retUnit = new ActionUnitUpgrade();
        retUnit.decorated = unit;
        retUnit.availableActions.addAll(actions);
        return retUnit;
    }


    @Override
    public HashSet<Action> getAvailableActions() {
        HashSet<Action> actions = this.decorated.getAvailableActions();
        actions.addAll(availableActions);
        return actions;
    }
}
