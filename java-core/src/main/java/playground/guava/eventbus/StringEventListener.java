package playground.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class StringEventListener {
    @Subscribe
    public void handle(String event) {
        System.out.println("string event received : " + event);
    }
}
