package Model.Unit.UnitAction;

import Model.Unit.IUnit;


public class OnlyUpgradedAction extends GenericAction {

    public static IAction instance = new OnlyUpgradedAction();


    private OnlyUpgradedAction() {
    }


    @Override
    protected boolean checkParameters(Object[] parameters) {
        return parameters.length >= 1
                && parameters[0] instanceof IUnit;
    }
}
