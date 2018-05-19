package Model.PlayerLastAction;

import Model.Player.PlayerLastAction.CaretakerOfLastAction;
import Model.Player.PlayerLastAction.LastAction;
import Model.Unit.UnitAction.AttackAction;
import Model.Unit.UnitAction.IAction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastActionTest {

    @Test
    public void CancelLastActionTest () {

        IAction attack = AttackAction.instance;


        CaretakerOfLastAction caretaker = new CaretakerOfLastAction();
        LastAction lastAction = new LastAction();

        lastAction.setLastAction(attack);
        caretaker.setRememberedAction(lastAction.saveLastAction());

        assertEquals(lastAction.getLastAction(), attack);

    }
}
