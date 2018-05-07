package Model.Unit.UnitAction;

import Model.Unit.IUnit;

public class ExampleAction implements IAction {

    public static final IAction instance = new ExampleAction();

    private ExampleAction() {}

    @Override
    public ActionResult perform(Object... parameters) {
        if(!checkParameters(parameters)) {
            return ActionResult.FAIL;
        }

        IUnit thisUnit = (IUnit) parameters[0];

        thisUnit.changeActionPoints(-1);
        return ActionResult.SUCCESS;
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
}
