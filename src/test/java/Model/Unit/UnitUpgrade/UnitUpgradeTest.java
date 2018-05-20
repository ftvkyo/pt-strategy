package Model.Unit.UnitUpgrade;

import Model.Player.Player;
import Model.Unit.ArcherUnit;
import Model.Unit.IUnit;
import Model.Unit.UnitAction.IAction;
import Model.Unit.UnitAction.OnlyUpgradedAction;
import Model.Unit.UnitBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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


        IAction oua = OnlyUpgradedAction.instance;
        assertFalse(unit.isAbleToPerform(oua));

        Set<IAction> actions = new HashSet<>();
        actions.add(oua);

        unit = ActionUnitUpgrade.upgradeUnit(unit, actions);
        assertTrue(unit.isAbleToPerform(oua));

        assertEquals(
                IAction.ActionResult.SUCCESS,
                oua.perform(unit)
        );
    }
}
