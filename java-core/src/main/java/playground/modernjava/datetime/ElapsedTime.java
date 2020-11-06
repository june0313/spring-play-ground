package playground.modernjava.datetime;

import java.time.Duration;
import java.time.Instant;

public class ElapsedTime {
    public static void main(String[] args) throws InterruptedException {
        Instant startInstant = Instant.now();

        Thread.sleep(5123);

        Instant endInstant = Instant.now();

        Duration elapsedTime = Duration.between(startInstant, endInstant);
        System.out.println("Elapsed Time : " + elapsedTime.getSeconds());
        System.out.println("Elapsed Time : " + elapsedTime.toMillis());
        System.out.println(elapsedTime.getNano());
    }
}
