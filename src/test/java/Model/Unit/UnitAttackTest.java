package Model.Unit;

import Model.Player.Player;
import Model.Unit.UnitAction.AttackAction;
import Model.Unit.UnitAction.IAction;
import Model.Unit.UnitAction.SimpleAction;
import org.junit.Test;

import static org.junit.Assert.*;


public class UnitAttackTest {

    @Test
    public void testUnitAttack_archer_and_cavalry_battle() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player p = new Player();
        myBuilder.setOwner(p);

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        IUnit cavalry = myBuilder.buildNewUnit();

        IAction attack = AttackAction.instance;


        assertTrue(archer.getCanIgnoreCounterAttack());
        assertFalse(cavalry.getCanIgnoreCounterAttack());

        assertTrue(archer.getAvailableActions().contains(attack));
        assertTrue(cavalry.getAvailableActions().contains(attack));

        /*
        Archer damage points: 20
        Cavalry damage points: 30
         */

        // [1] Start of archer turn
        archer.restoreActionPoints();

        assertEquals(10, archer.getActionPoints());
        assertEquals(14, cavalry.getActionPoints());

        assertTrue(attack.canPerform(archer));
        assertTrue(attack.canPerform(cavalry));

        assertEquals(
                IAction.ActionResult.WRONG_PARAMETERS,
                attack.perform(archer, "s")
        );
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(archer, cavalry)
        );

        assertEquals(70, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());
        assertEquals(100, cavalry.getHealthPoints());
        assertEquals(14, cavalry.getActionPoints());


        // [2] Start of cavalry turn
        cavalry.restoreActionPoints();

        assertEquals(14, cavalry.getActionPoints());
        assertEquals(0, archer.getActionPoints());

        assertTrue(attack.canPerform(cavalry));
        assertFalse(attack.canPerform(archer));
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(cavalry, archer)
        );

        assertEquals(80, cavalry.getHealthPoints());
        assertEquals(0, cavalry.getActionPoints());
        assertEquals(40, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());


        // [3] Start of archer turn
        archer.restoreActionPoints();

        assertEquals(10, archer.getActionPoints());
        assertEquals(0, cavalry.getActionPoints());

        assertTrue(attack.canPerform(archer));
        assertFalse(attack.canPerform(cavalry));
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(archer, cavalry)
        );

        assertEquals(40, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());
        assertEquals(60, cavalry.getHealthPoints());
        assertEquals(0, cavalry.getActionPoints());


        // [4] Start of cavalry turn
        cavalry.restoreActionPoints();

        assertEquals(14, cavalry.getActionPoints());
        assertEquals(0, archer.getActionPoints());

        assertTrue(attack.canPerform(cavalry));
        assertFalse(attack.canPerform(archer));
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(cavalry, archer)
        );

        assertEquals(40, cavalry.getHealthPoints());
        assertEquals(0, cavalry.getActionPoints());
        assertEquals(10, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());


        // [5] Start of archer turn
        archer.restoreActionPoints();

        assertEquals(10, archer.getActionPoints());
        assertEquals(0, cavalry.getActionPoints());

        assertTrue(attack.canPerform(archer));
        assertFalse(attack.canPerform(cavalry));
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(archer, cavalry)
        );

        assertEquals(10, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());
        assertEquals(20, cavalry.getHealthPoints());
        assertEquals(0, cavalry.getActionPoints());


        // [6] Start of cavalry turn
        cavalry.restoreActionPoints();

        assertEquals(14, cavalry.getActionPoints());
        assertEquals(0, archer.getActionPoints());

        assertTrue(attack.canPerform(cavalry));
        assertFalse(attack.canPerform(archer));
        assertEquals(
                IAction.ActionResult.SUCCESS,
                attack.perform(cavalry, archer)
        );

        assertEquals(20, cavalry.getHealthPoints());
        assertEquals(0, cavalry.getActionPoints());
        assertEquals(0, archer.getHealthPoints());
        assertEquals(0, archer.getActionPoints());


        // [7] After-battle checks
        assertFalse(attack.canPerform(cavalry));

        IAction sa = SimpleAction.instance;
        assertFalse(attack.canPerform(archer));
        assertFalse(sa.canPerform(archer));
        archer.restoreActionPoints();
        assertFalse(attack.canPerform(archer));
        assertFalse(sa.canPerform(archer));

        cavalry.restoreAllPoints();
        assertEquals(120, cavalry.getHealthPoints());
        assertEquals(14, cavalry.getActionPoints());

        assertEquals(
                IAction.ActionResult.FAIL,
                attack.perform(cavalry, archer)
        );
    }
}
