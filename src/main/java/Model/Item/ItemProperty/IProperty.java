package Model.Item.ItemProperty;

import Model.Item.GenericItem;
import Model.Unit.IUnit;


public interface IProperty {



    /**
     * Вызывается при активации Item'а.
     *
     * @param thisItem   Item, который был активирован
     * @param thisUnit   Unit, активировавший Item
     * @param targetUnit Unit, являющийся объектом применения Item'а (его может не быть)
     */
    void onActivate(GenericItem thisItem, IUnit thisUnit, IUnit targetUnit);


    /**
     * Вызывается при взятии Item'а Unit'ом.
     * Андрей, я не понимаю, зачем это :(
     *
     * @param thisItem Item, который был взят
     * @param thisUnit Unit, взявший Item
     */
    void onPickup(GenericItem thisItem, IUnit thisUnit);
}
