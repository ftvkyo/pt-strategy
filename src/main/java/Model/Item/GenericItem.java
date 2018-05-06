package Model.Item;

import Model.Item.ItemProperty.IProperty;

public class GenericItem {

    /**
     * Property of this item
     */
    private IProperty property;

    /**
     * Title of this item
     */
    private String title;

    /**
     * Default constructor without specific property
     */
    public GenericItem() {}

    /**
     * Constructor for items with properties
     * @param p Property to assign to this item
     */
    public GenericItem(IProperty p) {
        this.property = p;
    }

    /**
     * Setter for item's title.
     * @param title New title.
     */
    void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for item's title.
     * @return Current item's title.
     */
    public String getTitle() {
        return title;
    }
}
