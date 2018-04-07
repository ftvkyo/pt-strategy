package Model.Command;

import Model.Item.IItem;

public class ItemLevelUp implements ICommand {
    IItem item;

    public ItemLevelUp(IItem item) {
        this.item = item;
    }

    public void execute() {
        item.levelUp();
    }
}