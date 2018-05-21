package Model.Player.PlayerLastAction;

import Model.Unit.UnitAction.IAction;


/**
 * LastAction class.
 *
 * Основная способность - через Caretaker'а
 * может вернуться в сохранненное состояние.
 * реализует паттерн Хранитель
 */

public class LastAction {
    private IAction lastAction;

    public void setLastAction (IAction action) {
        this.lastAction = action;
    }

    public IAction getLastAction () {
        return lastAction;
    }

    public RememberedAction saveLastAction() {
        return new RememberedAction (lastAction);
    }

    public void restoreLastAction (RememberedAction rememberedAction) {
        this.lastAction = rememberedAction.getRememberedAction();
    }

}
