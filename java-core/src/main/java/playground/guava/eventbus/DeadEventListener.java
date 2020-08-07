package playground.guava.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

public class DeadEventListener {
    @Subscribe
    public void handle(DeadEvent deadEvent) {
        System.out.println("dead event posted");
        System.out.println("dead event : " + deadEvent.getEvent());
        System.out.println("dead event source : " + deadEvent.getSource());
    }
}
