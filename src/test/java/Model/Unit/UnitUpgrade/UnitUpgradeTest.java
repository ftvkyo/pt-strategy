package Model.Unit.UnitUpgrade;

import Model.Player.Player;
import Model.Unit.ArcherUnit;
import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;
import Model.Unit.UnitAction.OnlyUpgradedAction;
import Model.Unit.UnitBuilder;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class UnitUpgradeTest {

    @Test
    public void ActionUnitUpgradeTest() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player myPlayer = new Player();
        myBuilder.setOwner(myPlayer);

        IUnit unit;

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        unit = myBuilder.buildNewUnit();


        Action onlyUpgraded = OnlyUpgradedAction.getAction();
        assertFalse(onlyUpgraded.canPerform(unit));

        HashSet<Action> actions = new HashSet<>();
        actions.add(onlyUpgraded);
        unit = ActionUnitUpgrade.upgradeUnit(unit, actions);
        assertTrue(onlyUpgraded.canPerform(unit));

        assertEquals(
                Action.ActionResult.SUCCESS,
                onlyUpgraded.perform(unit, null, null)
        );
    }
}
