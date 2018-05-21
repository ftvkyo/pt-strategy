package Model.Player.PlayerLastAction;

import Model.Unit.UnitAction.IAction;


/**
 * RememberedAction class.
 *
 * Сохраненное Action, принадлежащее Caretaker'у
 */

public class RememberedAction {
    private IAction rememberedAction;

    public RememberedAction(IAction action) {
        this.rememberedAction = action;
    }

    public IAction getRememberedAction() {
        return rememberedAction;
    }
}
