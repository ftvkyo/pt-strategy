package Model.Unit;

import java.util.ArrayList;

import Model.Item.IItem;
import Model.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GenericUnit implements IUnit {
    Player owner;
    private ArrayList<IItem> inventory;

    GenericUnit() {
        inventory = new ArrayList<>();
    }

    public ArrayList<IItem> getInventory() { return (ArrayList<IItem>) inventory.clone(); }
    public void addItem(IItem item) { inventory.add(item); }
    public void removeItem(int n) { inventory.remove(n); }

    public class GenericUnitMaker {
        private Player owner;
        public GenericUnitMaker() {
            //TODO: Is this a good way to solve "default player" problem?
            throw new UnsupportedOperationException(
                    "UnitMaker should have an owner (Use UnitMaker(Player owner) instead)");
        }

        public GenericUnitMaker(Player owner) {
            this.owner = owner;
        }

        public void createUnit() {

        }

        public IUnit getUnit() {

        }

        public void setOwner() {

        }
    }
}
