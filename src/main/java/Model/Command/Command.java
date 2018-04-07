package Model.Command;

        import java.util.ArrayList;


public class Command {
    private ArrayList<ICommand> commands;

    public Command() {
        commands = new ArrayList<>();
    }

    //TODO: поменять названия переменных
    public ICommand.CommandResult setCommand(int numberOfChangingThing, ICommand command) {
        if (numberOfChangingThing > commands.size()) {
            return ICommand.CommandResult.CAN_NOT_MAKE_COMMAND;
        }
        if (numberOfChangingThing == commands.size()) {
            commands.add(command);
            return ICommand.CommandResult.CAN_MAKE_COMMAND;
        }
        commands.set(numberOfChangingThing, command);
        return ICommand.CommandResult.CAN_MAKE_COMMAND;
    }

    public void madeCommand(int numberOfChangingThing) {
        commands.get(numberOfChangingThing).execute();
    }
}
