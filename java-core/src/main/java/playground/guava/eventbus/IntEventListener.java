package playground.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class IntEventListener {
    @Subscribe
    public void handle(int event) {
        System.out.println(event);
    }
}
