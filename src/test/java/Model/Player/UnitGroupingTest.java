package Model.Player;

import Model.Unit.*;
import Model.Unit.UnitAction.Action;
import Model.Unit.UnitAction.OnlyArcherAction;
import Model.Unit.UnitAction.SimpleAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitGroupingTest {

    @Test
    public void UnitGroupingTest_SimpleAction() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player p = new Player();
        myBuilder.setOwner(p);


        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        IUnit infantry1 = myBuilder.buildNewUnit();

        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        IUnit infantry2 = myBuilder.buildNewUnit();

        Player.UnitGroup units = new Player.UnitGroup();

        Action sa = SimpleAction.getAction();

        assertTrue(sa.canPerform(archer) && sa.canPerform(infantry1) && sa.canPerform(infantry2));


        units.addUnit(archer);
        units.addUnit(infantry1);
        units.addUnit(infantry2);
        units.performAction(sa);


        assertEquals(7, infantry1.getActionPoints());
        assertEquals(7, infantry2.getActionPoints());
        assertEquals(9, archer.getActionPoints());
    }

    @Test
   public void UnitGroupingTest_ExampleAction() {
       UnitBuilder myBuilder = new UnitBuilder();
        Player p = new Player();
        myBuilder.setOwner(p);


        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        IUnit infantry = myBuilder.buildNewUnit();

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        IUnit cavalry1 = myBuilder.buildNewUnit();

        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        IUnit cavalry2 = myBuilder.buildNewUnit();


        Action onlyArcherAction = OnlyArcherAction.getAction();

        assertTrue(onlyArcherAction.canPerform(archer));
        assertFalse(onlyArcherAction.canPerform(infantry));
        assertFalse(onlyArcherAction.canPerform(cavalry1));
        assertFalse(onlyArcherAction.canPerform(cavalry2));


        Player.UnitGroup units = new Player.UnitGroup();

        units.addUnit(archer);
        assertTrue(units.canPerformAction(onlyArcherAction));

        units.addUnit(infantry);
        units.addUnit(cavalry1);
        units.addUnit(cavalry2);
        assertFalse(units.canPerformAction(onlyArcherAction));
    }
}
