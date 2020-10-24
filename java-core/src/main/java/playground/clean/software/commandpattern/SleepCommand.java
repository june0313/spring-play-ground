package playground.clean.software.commandpattern;

public class SleepCommand implements Command {
    private final long sleepTime;
    private final ActiveObjectEngine engine;
    private final Command wakeupCommand;
    private boolean started = false;
    private long startTime;

    public SleepCommand(long milliSeconds, ActiveObjectEngine engine, Command wakeupCommand) {
        this.sleepTime = milliSeconds;
        this.engine = engine;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();

        if (!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if ((currentTime - startTime) < sleepTime) {
            engine.addCommand(this);
        } else {
            engine.addCommand(wakeupCommand);
        }
    }
}
