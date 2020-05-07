package playground.batch.sample;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class SampleItemReader implements ItemReader<Long> {

    private Queue<Long> buffer = new LinkedList<>();

    @PostConstruct
    private void init() {
        List<Long> numberList = LongStream.iterate(0, i -> i + 1).limit(100000).boxed().collect(Collectors.toList());
        buffer.addAll(numberList);
    }

    @Override
    public Long read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (buffer.isEmpty()) {
            return null;
        }

        return buffer.poll();
    }
}
