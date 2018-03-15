package Model.Exceptions;

import Model.Unit.GenericUnit;

public class UnitDiedException extends Exception {
    public GenericUnit unit;

    public UnitDiedException() {}

    public UnitDiedException(String message) {
        super(message);
    }

    public UnitDiedException(GenericUnit unit) {
        this.unit = unit;
    }
}
