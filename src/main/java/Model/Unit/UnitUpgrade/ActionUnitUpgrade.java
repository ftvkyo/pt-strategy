package Model.Unit.UnitUpgrade;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.IAction;

import java.util.HashSet;


public class ActionUnitUpgrade extends GenericUnitUpgrade {

    /**
     * Множество действий, которые умеет декорированный юнит.
     * Set of actions, that we process inside of decorator.
     */
    private final HashSet<IAction> availableActions = new HashSet<>();


    /**
     * Процесс улучшения Unit'a.
     * TODO: Should I implement it as constructor?
     *
     * @param unit    юнит, который будет улучшен
     * @param actions действия, возможность совершать которое получит этот Unit
     * @return Улучшенный Unit
     */
    public static GenericUnitUpgrade upgradeUnit(IUnit unit, HashSet<IAction> actions) {
        ActionUnitUpgrade retUnit = new ActionUnitUpgrade();
        retUnit.decorated = unit;
        retUnit.availableActions.addAll(actions);
        return retUnit;
    }


    @Override
    public HashSet<IAction> getAvailableActions() {
        HashSet<IAction> actions = this.decorated.getAvailableActions();
        actions.addAll(availableActions);
        return actions;
    }
}
