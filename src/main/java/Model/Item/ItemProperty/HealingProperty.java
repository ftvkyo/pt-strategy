package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

public class HealingProperty extends GenericProperty {
    @Override
    public void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit) {
        thisUnit.changeHealthPoints(15);
        }
    }
