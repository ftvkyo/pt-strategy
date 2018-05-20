package Model.Unit.UnitAction;

import Model.Unit.IUnit;


public abstract class GenericAction implements IAction {

    protected abstract boolean checkParameters(Object[] parameters);

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
}
