package Model.Unit.UnitAction;

import Model.Item.GenericItem;
import Model.Unit.IUnit;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class AttackAction extends Action {

    private static Action instance = new AttackAction();

    private AttackAction() {}

    @Override
    public final ActionResult perform(@NotNull IUnit thisUnit, @NotNull IUnit targetUnit, @Nullable GenericItem item) {
        ActionResult retval = ActionResult.SUCCESS;
        if(thisUnit.getHealthPoints() > 0 && targetUnit.getHealthPoints() > 0) {
            targetUnit.changeHealthPoints(thisUnit.getDamagePoints());
            thisUnit.zeroActionPoints();

            if(!thisUnit.getCanIgnoreCounterAttack() && targetUnit.getHealthPoints() > 0) {
                thisUnit.changeHealthPoints(targetUnit.getDamagePoints());
            }
        } else {
            retval = ActionResult.FAIL;
        }

        return retval;
    }

    @NotNull
    public static Action getAction() {
        return instance;
    }
}
