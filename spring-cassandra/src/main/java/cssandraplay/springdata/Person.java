package cssandraplay.springdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Person {
    @Id
    private final String id;
    private final String firstName;
    private final String lastName;
}
