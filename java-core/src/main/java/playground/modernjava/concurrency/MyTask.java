package playground.modernjava.concurrency;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    private String id;

    public MyTask(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Task ID : " + id + ", running ... " + i);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
