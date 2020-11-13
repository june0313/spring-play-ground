package playground.modernjava.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        FutureExample futureExample = new FutureExample();
        futureExample.executeTest();
    }

    // 제곱을 계산하는 Callable 객체
    public Callable<Long> calSquare(long value) {
        return () -> {
            long returnValue = value * value;
            TimeUnit.SECONDS.sleep(1);
            System.out.println(value + "의 제곱은 " + returnValue);
            return returnValue;
        };
    }

    public void executeTest() {
        List<Long> sampleDataList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        List<Future<Long>>futureList = new ArrayList<>();

        ExecutorService servicePool = Executors.newFixedThreadPool(4);

        for (Long sampleValue : sampleDataList) {
            Future<Long> future = servicePool.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        // Future 목록의 결과를 확인
        for (Future<Long> future : futureList) {
            try {
                sumValue += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("최종 합계 : " + sumValue);

        servicePool.shutdown();
    }
}
