package Model.Player;

import Model.Unit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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

        units.addUnit(archer);
        units.addUnit(infantry1);
        units.addUnit(infantry2);

        IUnit.Action action = IUnit.Action.SIMPLE_ACTION;

        boolean canPerformActionOnGroup = false;

        boolean condition1 = archer.getAvailableActions().contains(action);
        boolean condition2 = infantry1.getAvailableActions().contains(action);
        boolean condition3 = infantry2.getAvailableActions().contains(action);

        if (condition1 && condition2 && condition3) {
            canPerformActionOnGroup = true;
        }


        assertEquals(true, canPerformActionOnGroup);


        if (canPerformActionOnGroup) {
            units.performAction(action);
        }


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

        Player.UnitGroup units = new Player.UnitGroup();

        units.addUnit(archer);
        units.addUnit(infantry);
        units.addUnit(cavalry1);
        units.addUnit(cavalry2);

        IUnit.Action action = IUnit.Action.EXAMPLE_ACTION;

        boolean canPerformActionOnGroup = false;

        boolean condition1 = archer.getAvailableActions().contains(action);
        boolean condition2 = infantry.getAvailableActions().contains(action);
        boolean condition3 = cavalry1.getAvailableActions().contains(action);
        boolean condition4 = cavalry2.getAvailableActions().contains(action);

        if (condition1 && condition2 && condition3 && condition4) {
            canPerformActionOnGroup = true;
        }


        assertEquals(false, canPerformActionOnGroup);


        if (canPerformActionOnGroup) {
            units.performAction(action);
        }


        assertEquals(8, infantry.getActionPoints());
        assertEquals(14, cavalry1.getActionPoints());
        assertEquals(14, cavalry2.getActionPoints());
        assertEquals(10, archer.getActionPoints());
    }
}
