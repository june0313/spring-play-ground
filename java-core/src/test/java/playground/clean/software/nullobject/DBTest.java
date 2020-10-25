package playground.clean.software.nullobject;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DBTest {
    @Test
    public void testNull() {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(LocalDate.now())) {
            fail();
        }
        assertEquals(Employee.NULL, e);
    }
}