package Model.Command;

import Model.Unit.IUnit;

public class UnitLevelUp {
    IUnit unit;

    public UnitLevelUp(IUnit unit) {
        this.unit = unit;
    }

    public void execute() {
        unit.levelUp();
    }
}
