package playground.clean.software.monostate;

public class Unlocked extends Turnstile {
    @Override
    public void coin() {
        refund();
    }

    @Override
    public void pass() {
        lock(true);
        state = LOCKED;
    }
}
