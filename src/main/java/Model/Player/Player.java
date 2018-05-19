package Model.Player;

import Model.Player.PlayerLastAction.CaretakerOfLastAction;
import Model.Player.PlayerLastAction.LastAction;
import Model.Unit.UnitGroup;


/**
 * Обычный класс игрока, который отвечает за действия от его имени.
 */
public class Player {

    private UnitGroup selectedUnits = new UnitGroup();

    public LastAction lastAction = new LastAction();
    public CaretakerOfLastAction caretaker = new CaretakerOfLastAction();

}
