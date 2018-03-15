package Model.Exceptions;

public class NotEnoughPointsException extends Exception {
    public NotEnoughPointsException() {}

    public NotEnoughPointsException(String message) {
        super(message);
    }
}
