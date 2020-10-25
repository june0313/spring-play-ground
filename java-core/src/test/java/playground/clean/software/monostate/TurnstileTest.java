package playground.clean.software.monostate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnstileTest {
    @Before
    public void setUp() {
        Turnstile t = new Turnstile();
        t.reset();
    }

    @Test
    public void testInit() {
        Turnstile t = new Turnstile();
        assertTrue(t.locked());
        assertFalse(t.alarm());
    }

    @Test
    public void testCoin() {
        Turnstile t = new Turnstile();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertFalse(t1.locked());
        assertFalse(t1.alarm());
        assertEquals(1, t1.coins());
    }

    @Test
    public void testCoinAndPass() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();

        Turnstile t1 = new Turnstile();
        assertTrue(t1.locked());
        assertFalse(t1.alarm());
        assertEquals("coins", 1, t1.coins());
    }

    @Test
    public void testTwoCoins() {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertFalse(t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(1, t1.refunds());
        assertFalse(t1.alarm());
    }
}