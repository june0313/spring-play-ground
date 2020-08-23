package playground.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
public class Member {
    private String name;
    private int age;
    private boolean active;
    @Accessors(fluent = true)
    private boolean hasBankAccount;
    private boolean havingBankAccount;
    private boolean bankAccountRegistered;
}
