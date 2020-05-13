package playground.batch.samplejob;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import playground.batch.entity.Sample;
import playground.batch.entity.SampleRepository;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class SampleItemWriter implements ItemWriter<Long> {
    private final SampleRepository sampleRepository;

    @Override
    public void write(List<? extends Long> items) throws Exception {
        log.info("chunk : " + items);

        if (items.contains(50L)) {
            throw new RuntimeException();
        }

        items.stream().map(Sample::new).forEach(sampleRepository::save);

        Thread.sleep(300);
    }
}
