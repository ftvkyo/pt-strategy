package Model.Player;

import Model.Player.PlayerLastAction.CaretakerOfLastAction;
import Model.Player.PlayerLastAction.LastAction;
import Model.Unit.UnitAction.IAction;
import Model.Unit.UnitGroup;


/**
 * Обычный класс игрока, который отвечает за действия от его имени.
 */
public class Player {

    private UnitGroup selectedUnits = new UnitGroup();

    private LastAction lastAction = new LastAction();
    private CaretakerOfLastAction caretaker = new CaretakerOfLastAction();


    public void setLastAction(LastAction lastAction) {
        this.lastAction = lastAction;
    }


    public LastAction getLastAction() {
        return this.lastAction;
    }


    public void setCaretaker(CaretakerOfLastAction caretaker) {
        this.caretaker = caretaker;
    }


    public CaretakerOfLastAction getCaretaker() {
        return this.caretaker;
    }


    public void restoreLastAction() {
        lastAction.restoreLastAction(caretaker.getLastAction());
    }
}
