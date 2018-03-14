package Model.Unit;

import java.util.ArrayList;

import Model.Item.IItem;
import Model.Player;

public class GenericUnit implements IUnit {
    Player owner;
    private ArrayList<IItem> inventory;

    GenericUnit() {
        inventory = new ArrayList<>();
    }

    public ArrayList<IItem> getInventory() { return (ArrayList<IItem>) inventory.clone(); }
    public void addItem(IItem item) { inventory.add(item); }
    public void removeItem(int n) { inventory.remove(n); }
}
