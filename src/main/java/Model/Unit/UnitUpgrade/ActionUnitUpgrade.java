package Model.Unit.UnitUpgrade;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.IAction;

import java.util.HashSet;
import java.util.Set;


public class ActionUnitUpgrade extends GenericUnitUpgrade {

    /**
     * Множество действий, которые умеет декорированный юнит.
     * Set of actions, that we process inside of decorator.
     */
    private final Set<IAction> availableActions = new HashSet<>();


    /**
     * Процесс улучшения Unit'a.
     * TODO: Should I implement it as constructor?
     *
     * @param unit    юнит, который будет улучшен
     * @param actions действия, возможность совершать которое получит этот Unit
     * @return Улучшенный Unit
     */
    public static GenericUnitUpgrade upgradeUnit(IUnit unit, Set<IAction> actions) {
        ActionUnitUpgrade retUnit = new ActionUnitUpgrade();
        retUnit.decorated = unit;
        retUnit.availableActions.addAll(actions);
        return retUnit;
    }


    @Override
    public boolean isActionAvailable(IAction action) {
        return this.decorated.isActionAvailable(action)
                || availableActions.contains(action);
    }


    @Override
    public boolean isAbleToPerform(IAction action) {
        return this.decorated.isAbleToPerform(action)
                || (this.getHealthPoints() > 0
                && this.getActionPoints() > 0
                && this.isActionAvailable(action));
    }
}
