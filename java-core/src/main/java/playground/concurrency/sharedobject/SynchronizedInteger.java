package playground.concurrency.sharedobject;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return this.value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
