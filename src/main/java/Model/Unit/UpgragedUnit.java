package Model.Unit;

import java.util.ArrayList;

/**
 * Decorator pattern: for upgrading units.
 * Adds some abilities to units.
 */
public class UpgragedUnit extends GenericUnit {

    /**
     * The Unit, that we are decorating.
     */
    private IUnit decorated;

    /**
     * The process of unit decoration.
     * @param decorated Unit to be decorated.
     */
    public UpgragedUnit(IUnit decorated) {
        this.decorated = decorated;
        this.availableActions.add(Action.ONLY_UPGRADED_ACTION);
    }


    @Override
    public ActionResult performAction(Action action) {
        ActionResult retval;
        if(this.availableActions.contains(action)) {
            switch(action) {
                case ONLY_UPGRADED_ACTION:
                    if(this.decorated.changeActionPoints(-1) == ActionResult.SUCCESS) {
                        this.decorated.changeHealthPoints(+10);
                    }
            }
        } else if(this.decorated.getAvailableActions().contains(action)) {
            retval = this.decorated.performAction(action);
        }
        return ActionResult.SUCCESS;
    }


    /*TODO: [VERY IMPORTANT] Decorator should override all methods of parent class to work with decorated object.*/
}
