package playground.clean.software.commandpattern;

public class DelayedTyper implements Command {
    private final long delay;
    private final char c;
    private static boolean stop = false;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();

    public static void main(String[] args) throws Exception {
        engine.addCommand(new DelayedTyper(1000, '1'));
//        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(5000, '5'));
//        engine.addCommand(new DelayedTyper(700, '7'));

        Command stopCommand = new Command() {
            @Override
            public void execute() throws Exception {
                stop = true;
            }
        };

        engine.addCommand(new SleepCommand(20000, engine, stopCommand));
        engine.run();
    }

    public DelayedTyper(long delay, char c) {
        this.delay = delay;
        this.c = c;
    }

    @Override
    public void execute() throws Exception {
        System.out.print(this.c);
        if (!stop) {
            delayAndRepeat();
        }
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(delay, engine, this));
    }
}
