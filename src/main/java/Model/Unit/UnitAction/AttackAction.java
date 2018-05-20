package Model.Unit.UnitAction;

import Model.Unit.IUnit;
import org.jetbrains.annotations.NotNull;


public class AttackAction extends GenericAction {

    public static final IAction instance = new AttackAction();


    private AttackAction() {
    }


    @Override
    public final ActionResult perform(@NotNull Object... parameters) {
        if(!checkParameters(parameters)) {
            return ActionResult.WRONG_PARAMETERS;
        }

        IUnit thisUnit = (IUnit) parameters[0];
        IUnit targetUnit = (IUnit) parameters[1];

        if(targetUnit.getHealthPoints() > 0) {
            targetUnit.changeHealthPoints(-thisUnit.getDamagePoints());
            thisUnit.zeroActionPoints();

            if(!thisUnit.getCanIgnoreCounterAttack() && targetUnit.getHealthPoints() > 0) {
                thisUnit.changeHealthPoints(-targetUnit.getDamagePoints());
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }


    @Override
    protected boolean checkParameters(Object[] parameters) {
        return parameters.length >= 2
                && parameters[0] instanceof IUnit
                && parameters[1] instanceof IUnit;
    }


    @Override
    public boolean canPerform(IUnit unit) {
        return unit.getHealthPoints() > 0
                && unit.getActionPoints() > 0
                && unit.getAvailableActions().contains(instance);
    }
}
