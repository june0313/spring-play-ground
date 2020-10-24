package playground.clean.software.commandpattern;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActiveObjectEngineTest {
    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {
        Command wakeupCommand = new Command() {
            @Override
            public void execute() throws Exception {
                commandExecuted = true;
            }
        };

        ActiveObjectEngine engine = new ActiveObjectEngine();
        SleepCommand sleepCommand = new SleepCommand(1000, engine, wakeupCommand);

        engine.addCommand(sleepCommand);

        long start = System.currentTimeMillis();
        engine.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;

        System.out.println(sleepTime);

        assertTrue("SleepTime " + sleepTime + " expected > 1000", sleepTime > 1000);
        assertTrue("SleepTime " + sleepTime + " expected < 1100", sleepTime < 1100);
        assertTrue("Command Executed", commandExecuted);
    }
}