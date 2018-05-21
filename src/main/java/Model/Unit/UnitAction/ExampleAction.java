package Model.Unit.UnitAction;

import Model.Player.Player;
import Model.Unit.IUnit;


public class ExampleAction extends GenericAction {

    public static IAction instance = new ExampleAction();


    private ExampleAction() {
    }


    @Override
    public ActionResult perform(Object... parameters) {
        if(!checkParameters(parameters)) {
            return ActionResult.FAIL;
        }

        IUnit thisUnit = (IUnit) parameters[0];

        thisUnit.changeActionPoints(-1);
        return ActionResult.SUCCESS;
    }


    @Override
    protected boolean checkParameters(Object[] parameters) {
        return parameters.length >= 1
                && parameters[0] instanceof IUnit;
    }
}
