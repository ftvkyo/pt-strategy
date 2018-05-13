package Model.Unit;

import Model.Item.GenericItem;
import Model.Player.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UnitBuilderTest {

    @Test
    public void testUnitCreation_allTypes() {
        UnitBuilder myBuilder = new UnitBuilder();
        Player myPlayer = new Player();
        myBuilder.setOwner(myPlayer);

        assertEquals(myPlayer, myBuilder.getOwner());

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
}
