package Model.Item;

import Model.Unit.IUnit;

class ExplosiveProperty extends ItemProperty {

    @Override
    public void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit) {
        thisItem.setTitle(thisItem.getTitle() + " [Exploded].");
        thisUnit.changeHealthPoints(-10);
    }
}
