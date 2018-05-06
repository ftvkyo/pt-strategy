package Model.Unit.UnitUpgrade;

import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;

import java.util.HashSet;

public class ActionUnitUpgrade extends GenericUnitUpgrade {

    /**
     * List of actions, that we process inside of decorator.
     */
    private final HashSet<Action> availableActions = new HashSet<>();


    /**
     * The process of unit upgrading.
     * TODO: Should I implement it as constructor?
     * @param unit the unit to be upgraded
     * @param actions the action, that should be added to this unit
     * @return the upgraded unit.
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
