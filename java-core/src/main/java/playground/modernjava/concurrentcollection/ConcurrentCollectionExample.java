package playground.modernjava.concurrentcollection;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExample {
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    Runnable producer = () -> {
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(1);
            int num = random.nextInt() % 10;
            queue.put(num);
            System.out.println("생성한 항목 값 : " + num + " 큐 크기 : " + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable consumer = () -> {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("소비한 항목 값 : " + queue.take() + " 큐 크기 : " + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    };

    public void execute(int producersSize, int consumersSize) {
        for (int i = 0; i < producersSize; i++) {
            new Thread(producer, "생성자 " + (i+1)).start();
        }

        for (int i = 0; i < consumersSize; i++) {
            new Thread(consumer, "소비자" + (i+1)).start();
        }
    }

    public static void main(String[] args) {
        ConcurrentCollectionExample example = new ConcurrentCollectionExample();
        example.execute(7, 9);
    }
}
