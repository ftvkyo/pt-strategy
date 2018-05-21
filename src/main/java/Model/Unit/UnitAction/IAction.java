package Model.Unit.UnitAction;

import Model.Player.Player;


/**
 * Generic IAction class.
 * <p>
 * Является синглтоном, при этом все наследники должны
 * инициализировать instance и иметь приватный конструктор.
 */
public interface IAction {

    enum ActionResult {SUCCESS, FAIL, WRONG_PARAMETERS}


    IAction instance = null;


    ActionResult perform(Object... parameters);

    void wasRestored(Player player);
}
