package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Unit.IUnit;


public class ExplosiveProperty extends GenericProperty {
    //TODO: Сделать так, чтобы Item'ы уничтожались после активации и совершения действий


    @Override
    public void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit) {
        thisUnit.changeHealthPoints(-10);
    }
}
