package playground.modernjava.concurrentcollection;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class ThreadLocalRandomExample {
    private final int low;
    private final int high;

    public void generateRandom7() {
        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(low, high));
        }
    }

    public void generateRandom8() {
        for (int i = 0; i < 100; i++) {
            ThreadLocalRandom.current().ints(100, low, high)
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        ThreadLocalRandomExample example = new ThreadLocalRandomExample(100, 1000);
        example.generateRandom7();
        example.generateRandom8();
    }
}
