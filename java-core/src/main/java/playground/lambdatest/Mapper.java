package playground.lambdatest;

import java.util.function.Function;

public class Mapper implements Function<Long, String> {
    @Override
    public String apply(Long aLong) {
        return aLong.toString();
    }
}
