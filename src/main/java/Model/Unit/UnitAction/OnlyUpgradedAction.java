package Model.Unit.UnitAction;

import Model.Unit.IUnit;


public class OnlyUpgradedAction extends GenericAction {

    public static final IAction instance = new OnlyUpgradedAction();


    private OnlyUpgradedAction() {
    }


    @Override
    protected boolean checkParameters(Object[] parameters) {
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
