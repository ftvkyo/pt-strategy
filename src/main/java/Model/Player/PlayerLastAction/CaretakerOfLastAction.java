package Model.Player.PlayerLastAction;

import Model.Unit.UnitAction.IAction;

/**
 * CaretakerOfLastAction class.
 *
 * Дает возможность сохранить и узнать последний Action,
 * реализует паттерн Хранитель
 */
public class CaretakerOfLastAction {
    private RememberedAction rememberedAction;

    public RememberedAction getLastAction () {
        return rememberedAction;
    }

    public void setRememberedAction (RememberedAction rememberedAction) {
        this.rememberedAction = rememberedAction;
    }
}
