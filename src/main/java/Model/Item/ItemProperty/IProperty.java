package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Unit.IUnit;

public interface IProperty {

    /**
     * Called on activation of the item.
     * @param thisItem Item, that was activated
     * @param thisUnit Unit, that activated the item
     * @param targetUnit Target unit (can be null)
     */
    void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit);

    /**
     * Called on picking up the item.
     * @param thisItem Item, that was picked up
     * @param thisUnit Unit, that picked up that item
     */
    void onPickup(GenericItem thisItem, IUnit thisUnit);
}
