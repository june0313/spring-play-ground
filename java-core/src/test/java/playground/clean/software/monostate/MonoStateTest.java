package playground.clean.software.monostate;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonoStateTest {
    @Test
    public void testInstance() {
        MonoState m = new MonoState();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            assertEquals(x, m.getX());
        }
    }

    @Test
    public void testInstancesBehaveAsOne() {
        MonoState m1 = new MonoState();
        MonoState m2 = new MonoState();

        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            assertEquals(x, m2.getX());
        }
    }
}