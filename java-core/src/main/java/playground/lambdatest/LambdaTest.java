package playground.lambdatest;

import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
        Function<Long, String> mapper = new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return aLong.toString();
            }
        };

        Function<Long, String> mapper2 = new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return aLong.toString();
            }
        };

        Stream.of(1L, null, 3L)
                .map(aLong -> LambdaTest.toString(aLong))
                .forEach(System.out::println);
    }

    private static String toString(Long aLong) {
        return aLong.toString();
    }
}
