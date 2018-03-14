package Model.Unit;

public interface IUnitMaker {
    void createUnit();
    void setOwner();
    void setInventory();
    void setDefaults();
    IUnit getUnit();
}