package playground.modernjava.concurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsideParallelStream {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        intList.parallelStream().forEach(value -> {
            String threadName = Thread.currentThread().getName();
            LocalDateTime currentTime = LocalDateTime.now();
            System.out.printf(currentTime.format(formatter) + " -> Thread Name : %s, Stream value : %s\n", threadName, value);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
