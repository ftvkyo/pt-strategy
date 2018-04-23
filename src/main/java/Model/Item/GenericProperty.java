package Model.Item;

import Model.Unit.IUnit;

class GenericProperty {
    public void onActivate(GenericItem item, IUnit unit) {}
    public void onPickup(GenericItem item, IUnit unit) {}
}

class ExplosiveProperty extends GenericProperty {
    @Override
    public void onActivate(GenericItem item, IUnit unit) {
        item.setTitle(item.getTitle() + " [Exploded].");
        unit.changeHealthPoints(-10);
    }
}
