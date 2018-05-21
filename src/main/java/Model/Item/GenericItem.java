package Model.Item;

import Model.HasIdentifier;
import Model.Item.ItemProperty.IProperty;


public class GenericItem implements HasIdentifier {

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


    @Override
    public String getID() {
        return "item-generic";
    }
}
