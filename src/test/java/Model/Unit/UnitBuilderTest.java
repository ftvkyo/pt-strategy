package Model.Unit;

import org.junit.Test;
import Model.Player;

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

        assertEquals(createdUnit.getActionPoints(), 10);
        assertEquals(createdUnit.getHealthPoints(), 70);
        assertEquals(createdUnit.getDamagePoints(), 20);


        myBuilder.setMaker(new CavalryUnit.UnitMaker());
        createdUnit = myBuilder.buildNewUnit();

        assertEquals(createdUnit.getActionPoints(), 14);
        assertEquals(createdUnit.getHealthPoints(), 120);
        assertEquals(createdUnit.getDamagePoints(), 30);


        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        createdUnit = myBuilder.buildNewUnit();

        assertEquals(createdUnit.getActionPoints(), 8);
        assertEquals(createdUnit.getHealthPoints(), 100);
        assertEquals(createdUnit.getDamagePoints(), 30);
    }
}