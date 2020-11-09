package playground.modernjava.concurrency;

import java.util.concurrent.Executor;

public class ExecutorExample implements Executor {
    @Override
    public void execute(Runnable task) {
        task.run();
        new Thread(task).start();
    }

    public static void main(String[] args) {
        ExecutorExample executor = new ExecutorExample();
        executor.execute(() -> System.out.println("Hello, Executor!"));
    }
}
