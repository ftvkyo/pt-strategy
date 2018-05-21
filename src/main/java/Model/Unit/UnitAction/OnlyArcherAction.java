package Model.Unit.UnitAction;

import Model.Player.Player;
import Model.Unit.IUnit;


public class OnlyArcherAction extends GenericAction {

    public static IAction instance = new OnlyArcherAction();


    private OnlyArcherAction() {
    }

    @Override
    protected boolean checkParameters(Object[] parameters) {
        return parameters.length >= 1
                && parameters[0] instanceof IUnit;
    }
}
