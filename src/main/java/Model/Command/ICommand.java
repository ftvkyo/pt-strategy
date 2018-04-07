package Model.Command;

public interface ICommand {
    enum CommandResult {CAN_MAKE_COMMAND, CAN_NOT_MAKE_COMMAND}
    void execute();
}