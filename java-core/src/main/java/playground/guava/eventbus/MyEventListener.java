package playground.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class MyEventListener {
    @Subscribe
    public void handle(MyEvent myEvent) {
        System.out.println("MyEvent : " + myEvent.getValue());
    }
}
