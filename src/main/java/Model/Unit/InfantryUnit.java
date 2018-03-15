package Model.Unit;

import Model.Player;

public class InfantryUnit extends GenericUnit {
    //

    public class UnitMaker extends GenericUnit.GenericUnitMaker {
        public UnitMaker(Player owner) {
            super(owner);
        }

        public void setInventory() {

        }

        public void setDefaults() {
            setActionPointsMax(10);
            setHealthPointsMax(100);
            setMovePointsMax(15);
            setDamagePoints(15);
        }
    }
}
