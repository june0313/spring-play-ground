package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteEmployeeTransactionTest {
    @Test
    public void test() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();
        assertNotNull(PayrollDatabase.getEmployee(empId));

        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();
        assertNull(PayrollDatabase.getEmployee(empId));
    }
}