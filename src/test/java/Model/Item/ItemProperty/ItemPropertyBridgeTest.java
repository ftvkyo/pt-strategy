package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Player.Player;
import Model.Unit.ArcherUnit;
import Model.Unit.IUnit;
import Model.Unit.InfantryUnit;
import Model.Unit.UnitBuilder;

import static org.junit.Assert.*;

import org.junit.Test;


public class ItemPropertyBridgeTest {

    @Test
    public void HealingPropertyTest() {
        IProperty healingProperty = new HealingProperty();

        GenericItem healingItem = new GenericItem(healingProperty);

        UnitBuilder myBuilder = new UnitBuilder();
        Player player = new Player();
        myBuilder.setMaker(new InfantryUnit.UnitMaker());
        IUnit infantry = myBuilder.buildNewUnit();
        infantry.changeHealthPoints(-20);

        healingProperty.onActivate(healingItem, infantry, null);


        assertEquals(95, infantry.getHealthPoints());
    }

    @Test
    public void ExplosivePropertyTest() {
        IProperty explosiveProperty = new ExplosiveProperty();

        GenericItem explosiveItem = new GenericItem(explosiveProperty);

        UnitBuilder myBuilder = new UnitBuilder();
        Player player = new Player();
        myBuilder.setMaker(new ArcherUnit.UnitMaker());
        IUnit archer = myBuilder.buildNewUnit();

        explosiveProperty.onActivate(explosiveItem, archer, null);


        assertEquals(60, archer.getHealthPoints());
    }
}
