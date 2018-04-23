package Model.Unit;

import Model.Item.GenericItem;
import org.junit.Test;
import Model.Player.Player;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnitBuilderTest {

    @Test
    public void testUnitCreation_allTypes() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player myPlayer = new Player();
        myBuilder.setOwner(myPlayer);

        IUnit createdUnit;

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        createdUnit = myBuilder.buildNewUnit();

        assertEquals(10, createdUnit.getActionPoints());
        assertEquals(70, createdUnit.getHealthPoints());
        assertEquals(20, createdUnit.getDamagePoints());


        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        createdUnit = myBuilder.buildNewUnit();

        assertEquals(14, createdUnit.getActionPoints());
        assertEquals(120, createdUnit.getHealthPoints());
        assertEquals(30, createdUnit.getDamagePoints());


        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        createdUnit = myBuilder.buildNewUnit();

        assertEquals(8, createdUnit.getActionPoints());
        assertEquals(100, createdUnit.getHealthPoints());
        assertEquals(30, createdUnit.getDamagePoints());
    }


    @Test
    public void testUnitInventory() {
        GenericUnit unit = new GenericUnit();
        GenericItem item = new GenericItem();
        ArrayList<GenericItem> l = new ArrayList<>();

        unit.addItem(item);
        l.add(item);

        assertEquals(l, unit.getItems());


        unit.removeItem(0);
        l.remove(0);

        assertEquals(l, unit.getItems());
    }


    @Test
    public void testUnitInteraction_archer_and_cavalry() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player p = new Player();
        myBuilder.setOwner(p);

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        IUnit cavalry = myBuilder.buildNewUnit();

        IUnit.AttackResult AResult;


        assertEquals(true, archer.getCanIgnoreCounterAttack());
        assertEquals(false, cavalry.getCanIgnoreCounterAttack());


        AResult = cavalry.attackUnit(archer);

        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);

        assertEquals(0, cavalry.getActionPoints());
        assertEquals(100, cavalry.getHealthPoints());
        assertEquals(30, cavalry.getDamagePoints());

        assertEquals(10, archer.getActionPoints());
        assertEquals(40, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());


        AResult = archer.attackUnit(cavalry);

        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);

        assertEquals(0, archer.getActionPoints());
        assertEquals(40, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());

        assertEquals(0, cavalry.getActionPoints());
        assertEquals(80, cavalry.getHealthPoints());
        assertEquals(30, cavalry.getDamagePoints());


        cavalry.changeActionPoints(+1);
        AResult = cavalry.attackUnit(archer);

        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);

        assertEquals(0, cavalry.getActionPoints());
        assertEquals(60, cavalry.getHealthPoints());
        assertEquals(30, cavalry.getDamagePoints());

        assertEquals(0, archer.getActionPoints());
        assertEquals(10, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());


        cavalry.changeActionPoints(+1);
        AResult = cavalry.attackUnit(archer);

        assertEquals(IUnit.AttackResult.DEFENDER_DIED, AResult);

        assertEquals(0, cavalry.getActionPoints());
        assertEquals(60, cavalry.getHealthPoints());
        assertEquals(30, cavalry.getDamagePoints());

        assertEquals(0, archer.getActionPoints());
        assertEquals(0, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());
    }


    @Test
    public void testUnitInteraction_archer_and_infantry() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player p = new Player();
        myBuilder.setOwner(p);

        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        IUnit infantry = myBuilder.buildNewUnit();

        IUnit.AttackResult AResult;


        AResult = archer.attackUnit(infantry);

        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);

        assertEquals(0, archer.getActionPoints());
        assertEquals(70, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());

        assertEquals(8, infantry.getActionPoints());
        assertEquals(80, infantry.getHealthPoints());
        assertEquals(30, infantry.getDamagePoints());


        AResult = infantry.attackUnit(archer);

        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);

        assertEquals(0, infantry.getActionPoints());
        assertEquals(60, infantry.getHealthPoints());
        assertEquals(30, infantry.getDamagePoints());

        assertEquals(0, archer.getActionPoints());
        assertEquals(40, archer.getHealthPoints());
        assertEquals(20, archer.getDamagePoints());


        archer.restoreAllPoints();
        infantry.changeActionPoints(+1);
        AResult = infantry.attackUnit(archer);
        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);
        assertEquals(40, infantry.getHealthPoints());


        archer.restoreAllPoints();
        infantry.changeActionPoints(+1);
        AResult = infantry.attackUnit(archer);
        assertEquals(IUnit.AttackResult.NOBODY_DIED, AResult);
        assertEquals(20, infantry.getHealthPoints());


        archer.restoreAllPoints();
        infantry.changeActionPoints(+1);
        AResult = infantry.attackUnit(archer);
        assertEquals(IUnit.AttackResult.ATTACKER_DIED, AResult);
        assertEquals(0, infantry.getHealthPoints());
    }
}
