package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeCardTransactionTest {
    @Test
    public void testTimeCardTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(empId, 20011031, 8.0);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getPaymentClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assertNotNull(hc);

        TimeCard tc = hc.getTimeCard(20011031);
        assertNotNull(tc);
        assertEquals(8.0, tc.getHours(), 0.1);
    }
}