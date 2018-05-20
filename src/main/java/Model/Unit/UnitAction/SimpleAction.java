package Model.Unit.UnitAction;

import Model.Unit.IUnit;


public class SimpleAction extends GenericAction {

    public static IAction instance = new SimpleAction();


    private SimpleAction() {
    }


    @Override
    protected boolean checkParameters(Object[] parameters) {
        return parameters.length >= 1
                && parameters[0] instanceof IUnit;
    }
}
