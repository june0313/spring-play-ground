package playground.concurrency.ch04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    // X
    public synchronized boolean putIfAbsent1(E x) {
        boolean absent = !list.contains(x);

        if (absent) {
            list.add(x);
        }

        return absent;
    }

    // O
    public synchronized boolean putIfAbsent2(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);

            if (absent) {
                list.add(x);
            }

            return absent;
        }
    }
}
