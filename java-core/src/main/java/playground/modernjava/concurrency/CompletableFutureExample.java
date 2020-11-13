package playground.modernjava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // 첫 번째 Runnable 인터페이스를 정의
        Runnable mainTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) { }

            System.out.println("Main Task : " + Thread.currentThread().getName());
        };

        Runnable subTask = () -> System.out.println("Next Task : " + Thread.currentThread().getName());

        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);

        executor.shutdown();
    }
}
