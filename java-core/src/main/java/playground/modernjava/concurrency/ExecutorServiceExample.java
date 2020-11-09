package playground.modernjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MyTask("TODO 1"));
        executorService.execute(new MyTask("TODO 2"));
        executorService.execute(new MyTask("TODO 3"));
        executorService.shutdown();
    }
}
