package playground.modernjava.concurrency;

import java.util.Arrays;
import java.util.List;

public class ParallelReduceMinMax {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(4, 2, 8, 1, 9, 6, 7, 3, 5);

        Integer max = intList.parallelStream().reduce(1, Integer::max);
        System.out.println("max : " + max);

        Integer min = intList.parallelStream().reduce(1, Integer::min);
        System.out.println("min : " + min);
    }
}
