package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddCommissionedEmployeeTest {
    @Test
    public void test() {
        int empId = 1;

        AddCommissionedEmployee transaction = new AddCommissionedEmployee(empId, "bob", "home", 1000.0, 100.0);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(1);
        assertEquals(employee.getName(), "bob");
        assertEquals(employee.getAddress(), "home");
        assertEquals(employee.getId(), empId);

        PaymentClassification pc = employee.getPaymentClassification();
        assertEquals(pc.getClass(), CommissionedClassification.class);

        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(cc.getSalary(), 1000.00, .001);
        assertEquals(cc.getCommissionRate(), 100.00, .001);

        PaymentSchedule ps = employee.getPaymentSchedule();
        assertEquals(ps.getClass(), BiweeklySchedule.class);

        PaymentMethod pm = employee.getPaymentMethod();
        assertEquals(pm.getClass(), HoldMethod.class);
    }
}