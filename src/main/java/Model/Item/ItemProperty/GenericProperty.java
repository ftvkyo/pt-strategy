package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

/**
 * Bridge pattern.
 * Allows Items to have unified side effects.
 */
class GenericProperty implements IProperty {

    public void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit) {}

    public void onPickup(GenericItem thisItem, IUnit thisUnit) {}
}

