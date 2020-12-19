package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddSalariedEmployeeTest {
    @Test
    public void test() {
        int empId = 1;
        AddSalariedEmployee transaction = new AddSalariedEmployee(empId, "bob", "home", 1000.0);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        assertEquals("bob", employee.getName());

        PaymentClassification pc = employee.getPaymentClassification();
        assertEquals(pc.getClass(), SalariedClassification.class);

        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(sc.getSalary(), 1000.00, .001);

        PaymentSchedule ps = employee.getPaymentSchedule();
        assertEquals(ps.getClass(), MonthlySchedule.class);

        PaymentMethod pm = employee.getPaymentMethod();
        assertEquals(pm.getClass(), HoldMethod.class);
    }
}