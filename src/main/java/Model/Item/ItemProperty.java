package Model.Item;

import Model.Unit.IUnit;

/**
 * Bridge pattern.
 * Allows Items to have unified side effects.
 */
class ItemProperty {

    /**
     * Called on activation of the item.
     * @param thisItem Item, that was activated
     * @param thisUnit Unit, that activated the item
     * @param targetUnit Target unit (can be null)
     */
    public void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit) {}


    /**
     * Called on picking up the item.
     * @param thisItem Item, that was picked up
     * @param thisUnit Unit, that picked up that item
     */
    public void onPickup(GenericItem thisItem, IUnit thisUnit) {}
}

