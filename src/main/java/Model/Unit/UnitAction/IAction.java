package Model.Unit.UnitAction;

import Model.Unit.IUnit;

/**
 * Generic IAction class.
 *
 * Является синглтоном, при этом все наследники должны
 * инициализировать instance и иметь приватный конструктор.
 * TODO?: сделать GenericAction для избежания дублирования кода
 */
public interface IAction {
    enum ActionResult { SUCCESS, FAIL, WRONG_PARAMETERS }

    IAction instance = null;

    ActionResult perform(Object... parameters);

    boolean canPerform(IUnit unit);
}
