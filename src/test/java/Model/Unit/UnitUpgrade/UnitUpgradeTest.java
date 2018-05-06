package Model.Unit.UnitUpgrade;

import Model.Player.Player;
import org.junit.Test;
import Model.Unit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UnitUpgradeTest {

    @Test
    public void ActionUnitUpgradeTest() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player myPlayer = new Player();
        myBuilder.setOwner(myPlayer);

        IUnit unit;

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        unit = myBuilder.buildNewUnit();


        IUnit.Action action = IUnit.Action.ONLY_UPGRADED_ACTION;
        ArrayList<IUnit.Action> actions = new ArrayList<>();
        actions.add(action);

        assertEquals(IUnit.ActionResult.ACTION_UNAVAILABLE, unit.performAction(IUnit.Action.ONLY_UPGRADED_ACTION));

        GenericUnitUpgrade myUnitUpgrade = ActionUnitUpgrade.upgradeUnit(unit, actions);

        assertEquals(IUnit.ActionResult.SUCCESS, myUnitUpgrade.performAction(IUnit.Action.ONLY_UPGRADED_ACTION));
    }
}
