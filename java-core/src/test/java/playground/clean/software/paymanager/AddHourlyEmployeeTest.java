package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddHourlyEmployeeTest {
    @Test
    public void test() {
        int empId = 1;

        AddHourlyEmployee transaction = new AddHourlyEmployee(empId, "bob", "home", 100.0);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(1);
        assertEquals(employee.getName(), "bob");
        assertEquals(employee.getAddress(), "home");
        assertEquals(employee.getId(), empId);

        PaymentClassification pc = employee.getPaymentClassification();
        assertEquals(pc.getClass(), HourlyClassification.class);

        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(hc.getHourlyRate(), 100.00, .001);

        PaymentSchedule ps = employee.getPaymentSchedule();
        assertEquals(ps.getClass(), WeeklySchedule.class);

        PaymentMethod pm = employee.getPaymentMethod();
        assertEquals(pm.getClass(), HoldMethod.class);
    }
}