package Model.Unit;

import Model.Player;

public class CavalryUnit extends GenericUnit {
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
            setMovePointsMax(20);
            setDamagePoints(20);
        }
    }
}
