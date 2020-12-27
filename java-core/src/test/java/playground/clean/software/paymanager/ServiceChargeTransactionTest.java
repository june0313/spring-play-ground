package playground.clean.software.paymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceChargeTransactionTest {
    @Test
    public void test() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        UnionAffiliation af = new UnionAffiliation(12.5);
        e.setAffiliation(af);

        int memberId = 86; // Maxwell Smart
        PayrollDatabase.addUnionMember(memberId, e);

        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011101, 12.95);
        sct.execute();

        ServiceCharge sc =  af.getServiceCharge(20011101);
        assertNotNull(sc);
        assertEquals(12.95, sc.getAmount(), .001);
    }
}