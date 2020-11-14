package playground.modernjava.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@ToString
public class HelloPerson {
    private String firstName;
    private String lastName;
    private String country;

    public static List<HelloPerson> getSampleData() {
        List<HelloPerson> person = new ArrayList<>();
        person.add(HelloPerson.of("AAA", "A", "KOREA"));
        person.add(HelloPerson.of("BBB", "B", "JAPAN"));
        person.add(HelloPerson.of("CCC", "C", "AMERICA"));
        person.add(HelloPerson.of("DDD", "D", "남극"));
        person.add(HelloPerson.of("AAEEEEEA", "E", "중국"));
        return person;
    }
}
