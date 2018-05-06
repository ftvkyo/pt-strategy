package Model.Unit.UnitAction;

import Model.Item.GenericItem;
import Model.Unit.IUnit;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Generic Action class.
 *
 * Является синглтоном, при этом все наследники должны переопределять
 * getAction() как public, инициализировать instance и иметь приватный конструктор.
 */
public abstract class Action {
    public enum ActionResult { SUCCESS, FAIL }

    private static Action instance = null;

    abstract public ActionResult perform(@NotNull IUnit thisUnit, @Nullable IUnit targetUnit, @Nullable GenericItem item);

    public boolean canPerform(@NotNull IUnit unit) {
        return unit.getActionPoints() > 0 && unit.getHealthPoints() > 0 && unit.getAvailableActions().contains(this);
    }

    @Nullable
    private static Action getAction() {
        return instance;
    }
}
