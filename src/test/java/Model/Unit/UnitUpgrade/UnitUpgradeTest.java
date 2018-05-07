package Model.Unit.UnitUpgrade;

import Model.Player.Player;
import Model.Unit.ArcherUnit;
import Model.Unit.IUnit;
import Model.Unit.UnitAction.IAction;
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


        IAction onlyUpgraded = OnlyUpgradedAction.instance;
        assertFalse(onlyUpgraded.canPerform(unit));

        HashSet<IAction> actions = new HashSet<>();
        actions.add(onlyUpgraded);
        unit = ActionUnitUpgrade.upgradeUnit(unit, actions);
        assertTrue(onlyUpgraded.canPerform(unit));

        assertEquals(
                IAction.ActionResult.SUCCESS,
                onlyUpgraded.perform(unit, null, null)
        );
    }
}
