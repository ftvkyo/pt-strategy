package Model.Player.PlayerLastAction;

import Model.Unit.UnitAction.IAction;

public class CaretakerOfLastAction {
    private RememberedAction rememberedAction;

    public RememberedAction getLastAction () {
        return rememberedAction;
    }

    public void setRememberedAction (RememberedAction rememberedAction) {
        this.rememberedAction = rememberedAction;
    }
}
