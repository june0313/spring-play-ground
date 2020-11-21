package cssandraplay.springdata;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CassandraApplication implements CommandLineRunner {
    private final PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CassandraApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args).close();
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(Person.of("june0313", "Wayne", "Park"));
        personRepository.save(Person.of("asd", "Fef", "Pacccrk"));
        personRepository.save(Person.of("asdwc", "sdfsdf", "vssdf"));

        for (Person person : personRepository.findAll()) {
            System.out.println(person);
        }
    }
}
