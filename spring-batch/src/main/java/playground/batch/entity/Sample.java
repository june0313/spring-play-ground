package playground.batch.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Sample {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value")
    private Long value;

    public Sample(Long value) {
        this.value = value;
    }
}
