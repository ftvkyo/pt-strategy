package Model.Item;

import Model.Item.ItemProperty.IProperty;
import Model.Unit.IUnit;

import java.util.ArrayList;


public class GenericItem {

    /**
     * Свойство Item'a.
     */
    private IProperty property;

    /**
     * Название Item'a.
     */
    private String title;


    /**
     * Дефолтный конструктор без определенного свойства.
     */
    public GenericItem() {
    }


    /**
     * Конструктор для Items со свойствами.
     *
     * @param p Свойство, которое будет присвоено Item'у
     */
    public GenericItem(IProperty p) {
        this.property = p;
    }

    /**
     * Использование предмета
     * @param thisUnit юнит, который использует Item
     * @param targetUnit юнит, на котором использую Item
     */
    public void useItem (IUnit thisUnit, IUnit targetUnit) {

        ArrayList<GenericItem> items = thisUnit.getItems();

        int itemIndex = items.indexOf(this);
        if (itemIndex != -1) {
            this.property.onActivate(this, thisUnit, targetUnit);
            thisUnit.removeItem(itemIndex);
        }
    }


    /**
     * Сэттер для названия Item'a.
     *
     * @param title название, которое будет присвоено Item'у
     */
    void setTitle(String title) {
        this.title = title;
    }


    /**
     * Геттер для названия Item'a.
     *
     * @return Текущее название Item'a
     */
    public String getTitle() {
        return title;
    }

}
