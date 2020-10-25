package playground.clean.software.monostate;

public class Turnstile {
    private static boolean isLocked = true;
    private static boolean isAlarming = false;
    private static int coins = 0;
    private static int refunds = 0;
    protected final static Turnstile LOCKED = new Locked();
    protected final static Turnstile UNLOCKED = new Unlocked();
    protected static Turnstile state = LOCKED;

    public void reset() {
        lock(true);
        alarm(false);
        coins = 0;
        refunds = 0;
        state = LOCKED;
    }

    public boolean locked() {
        return isLocked;
    }

    public boolean alarm() {
        return isAlarming;
    }

    public void coin() {
        state.coin();
    }

    public void pass() {
        state.pass();
    }

    protected void lock(boolean shouldLock) {
        isLocked = shouldLock;
    }

    protected void alarm(boolean shouldAlarm) {
        isAlarming = shouldAlarm;
    }

    public int coins() {
        return coins;
    }

    public int refunds() {
        return refunds;
    }

    public void deposit() {
        coins++;
    }

    public void refund() {
        refunds++;
    }
}


