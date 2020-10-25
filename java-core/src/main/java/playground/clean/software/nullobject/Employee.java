package playground.clean.software.nullobject;

import java.time.LocalDate;

public interface Employee {
    boolean isTimeToPay(LocalDate payDate);

    void pay();

    Employee NULL = new Employee() {
        @Override
        public boolean isTimeToPay(LocalDate payDate) {
            return false;
        }

        @Override
        public void pay() {
            System.out.println("Do Nothing");
        }
    };
}
