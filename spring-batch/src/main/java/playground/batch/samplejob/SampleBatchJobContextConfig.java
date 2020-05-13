package playground.batch.samplejob;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
public class SampleBatchJobContextConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SampleItemReader sampleItemReader;
    private final SampleItemWriter sampleItemWriter;

    @Bean
    public Job sampleJob() {
        return jobBuilderFactory.get("sampleJob")
                .start(sampleStep())
                .build();
    }

    @Bean
    public Step sampleStep() {
        return stepBuilderFactory.get("sampelStep")
                .<Long, Long>chunk(5)
                .reader(sampleItemReader)
                .writer(sampleItemWriter)
                .build();
    }
}
