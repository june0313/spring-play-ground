package playground.clean.software.monostate;

class Locked extends Turnstile {
    @Override
    public void coin() {
        state = UNLOCKED;
        lock(false);
        alarm(false);
        deposit();
    }

    @Override
    public void pass() {
        alarm(true);
    }
}
