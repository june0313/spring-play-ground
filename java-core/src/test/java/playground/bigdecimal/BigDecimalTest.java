package playground.bigdecimal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    public void test1() {
        BigDecimal a = BigDecimal.valueOf(100.0);
        BigDecimal b = BigDecimal.valueOf(100.0);

        System.out.println(a == b);
    }

    @Test
    public void test2() {
        BigDecimal a = BigDecimal.valueOf(100.0);
        BigDecimal b = BigDecimal.valueOf(100.0);

        System.out.println(a.equals(b));
    }

    @Test
    public void test3() {
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(3);

        int compareResult = a.compareTo(b);
        if (compareResult < 0) {
            System.out.println(compareResult);
            System.out.println("a가 b보다 작다.");
        }

        if (compareResult == 0) {
            System.out.println("a와 b가 같다.");
        }

        if (compareResult > 0) {
            System.out.println("a가 b보다 크다.");
        }
    }
}
