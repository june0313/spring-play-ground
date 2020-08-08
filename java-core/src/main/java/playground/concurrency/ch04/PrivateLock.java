package playground.concurrency.ch04;

import javax.annotation.concurrent.GuardedBy;

public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    private String value;

    void someMethod() {
        synchronized (myLock) {
            // value를 읽거나 변경...
        }
    }
}
