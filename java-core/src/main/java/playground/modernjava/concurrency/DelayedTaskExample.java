package playground.modernjava.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTaskExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(() -> System.out.println("TODO 1"), 5, 3, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(() -> System.out.println("TODO 2"), 10, 5, TimeUnit.SECONDS);
        executor.schedule(() -> System.out.println("TODO 3"), 15, TimeUnit.SECONDS);
    }
}
