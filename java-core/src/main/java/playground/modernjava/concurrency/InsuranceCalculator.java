package playground.modernjava.concurrency;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsuranceCalculator {
    public int calculatePrice(Map<String, String> condition) {
        int price = 10000;

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return price;
    }

    public Future<Integer> calculatePriceAsync(Map<String, String> condition) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            int price = calculatePrice(condition);
            future.complete(price);
        }).start();
        return future;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        InsuranceCalculator insuranceCalculator = new InsuranceCalculator();

        // sync
        for (int i = 0; i < 5; i++) {
            System.out.printf("계산 차수 : %s : %s\n", (i+1), insuranceCalculator.calculatePrice(null));
        }

        System.out.println("------------------------");

        // async
        List<Future<Integer>> futures = IntStream.range(1, 6)
                .mapToObj(i -> insuranceCalculator.calculatePriceAsync(null))
                .collect(Collectors.toList());

        for (int i = 0; i < futures.size(); i++) {
            System.out.printf("계산 차수 : %s : %s\n", (i+1), futures.get(i).get());
        }
    }
}
