package Model.Unit;

import java.util.ArrayList;

import Model.Item.IItem;

public class GenericUnit implements IUnit {
    private ArrayList<IItem> items;

    GenericUnit() {
        items = new ArrayList<>();
    }

    public ArrayList<IItem> getItems() { return (ArrayList<IItem>) items.clone(); }
    public void addItem(IItem item) { items.add(item); }
    public void removeItem(int n) { items.remove(n); }
}
