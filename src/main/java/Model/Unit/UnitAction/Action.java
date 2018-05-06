package Model.Unit.UnitAction;

import Model.Item.GenericItem;
import Model.Unit.IUnit;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Generic Action class.
 *
 * Является синглтоном, при этом все наследники должны переопределять getAction(),
 * инициализировать instance и иметь приватный конструктор.
 */
public abstract class Action {
    public enum ActionResult { SUCCESS, FAIL }

    private static Action instance;

    abstract ActionResult perform(@NotNull IUnit thisUnit, @Nullable IUnit targetUnit, @Nullable GenericItem item);

    @Nullable
    static Action getAction() {
        return null;
    }
}
