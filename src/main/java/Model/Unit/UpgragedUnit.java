package Model.Unit;

import java.util.ArrayList;

public class UpgragedUnit extends GenericUnit {
    private IUnit decorated;

    public UpgragedUnit(IUnit decorated) {
        this.decorated = decorated;
        this.availableActions.add(Action.EXAMPLE_ACTION);
    }

    @Override
    public ActionResult performAction(Action action) {
        if(this.availableActions.contains(action)) {
            /*TODO: perform action*/
        } else if(this.decorated.getAvailableActions().contains(action)) {
            /*TODO: perform action*/
        }
        /*TODO*/
        return ActionResult.SUCCESS;
    }
}
