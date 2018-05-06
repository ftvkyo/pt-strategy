package Model.Unit.UnitUpgrade;

import Model.Unit.IUnit;

import java.util.ArrayList;

public class ActionUnitUpgrade extends GenericUnitUpgrade {

    /**
     * List of actions, that we process inside of decorator.
     */
    ArrayList<IUnit.Action> availableActions = new ArrayList<>();


    /**
     * The process of unit upgrading.
     * TODO: Should I implement it as constructor?
     * @param unit the unit to be upgraded
     * @param actions the action, that should be added to this unit
     * @return the upgraded unit.
     */
    public GenericUnitUpgrade upgradeUnit(IUnit unit, ArrayList<Action> actions) {
        ActionUnitUpgrade retUnit = new ActionUnitUpgrade();
        retUnit.decorated = unit;
        retUnit.availableActions.addAll(actions);
        return retUnit;
    }


    @Override
    public ActionResult performAction(Action action) {
        //TODO: After implementation of "more complex actions".
        changeActionPoints(-1);
        return ActionResult.SUCCESS;
    }
}
