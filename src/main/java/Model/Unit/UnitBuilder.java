package Model.Unit;

import Model.Player;


/**
 * Part of implementation of Builder Design Pattern.
 */
public class UnitBuilder {

    /**
     * Current UnitMaker;
     */
    private GenericUnit.GenericUnitMaker maker;


    /**
     * Owner of this UnitBuilder and produced Units.
     */
    private Player owner;


    /**
     * Setter for UnitMaker
     * @param maker New UnitMaker to be "plugged".
     */
    public void setMaker(GenericUnit.GenericUnitMaker maker) {
        this.maker = maker;
    }


    /**
     * Setter for owner of UnitBuilder and produced Units.
     * @param owner New owner to be set.
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }


    /**
     * Getter for current owner of UnitBuilder and produced Units.
     * @return Current owner.
     */
    public Player getOwner() {
        return owner;
    }


    /**
     * Main method for unit creation.
     * Setters for Maker and Owner should be called before this method.
     * @return Created unit.
     */
    public IUnit buildNewUnit() {
        maker.createUnit();
        maker.setOwner(this.owner);
        maker.setDefaults();
        maker.setInventory();
        return maker.getUnit();
    }
}
