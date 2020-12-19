package playground.clean.software.paymanager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Employee {
    private final int id;
    private final String name;
    private final String address;
    @Setter
    private PaymentClassification paymentClassification;
    @Setter
    private PaymentSchedule paymentSchedule;
    @Setter
    private PaymentMethod paymentMethod;
}
