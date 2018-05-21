package Model.Unit.UnitAction;

import Model.Player.Player;
import Model.Unit.IUnit;


public class OnlyUpgradedAction implements IAction {

    public static final IAction instance = new OnlyUpgradedAction();


    private OnlyUpgradedAction() {
    }


    @Override
    public ActionResult perform(Object... parameters) {
        if(!checkParameters(parameters)) {
            return ActionResult.FAIL;
        }

        IUnit thisUnit = (IUnit) parameters[0];

        ActionResult retval = ActionResult.SUCCESS;
        thisUnit.changeActionPoints(-1);
        return retval;
    }


    private boolean checkParameters(Object[] parameters) {
        return parameters.length >= 1
                && parameters[0] instanceof IUnit;
    }


    @Override
    public boolean canPerform(IUnit unit) {
        return unit.getHealthPoints() > 0
                && unit.getActionPoints() > 0
                && unit.getAvailableActions().contains(instance);
    }

    @Override
    public void wasRestored(Player player) {

    }
}
