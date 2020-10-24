package playground.clean.software.commandpattern;

import java.util.LinkedList;

public class ActiveObjectEngine {
    private LinkedList<Command> commands = new LinkedList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void run() throws Exception {
        while (!commands.isEmpty()) {
            Command command = commands.getFirst();
            commands.removeFirst();
            command.execute();
        }
    }
}
