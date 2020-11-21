package playground.modernjava.concurrentcollection;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RandomExample {

    public static final int SIZE = 1000000;

    public static void main(String[] args) {
        int high = 1000;
        int low = 100;

        Random random = new Random();
        Instant start = Instant.now();
        for (int i = 0; i < SIZE; i++) {
            getRandomByRandom(high, low, random);
        }
        Instant end = Instant.now();
        System.out.println("\n소요시간 : " + ChronoUnit.MILLIS.between(start, end));


        Instant start2 = Instant.now();
        for (int i = 0; i < SIZE; i++) {
            getRandomByMath(high, low);
        }
        Instant end2 = Instant.now();
        System.out.println("\n소요시간 : " + ChronoUnit.MILLIS.between(start2, end2));
    }

    private static int getRandomByRandom(int high, int low, Random random) {
        return random.nextInt(high - low) + low;
    }

    private static int getRandomByMath(int high, int low) {
        return (int) (Math.random() * (high - low)) + low;
    }
}
