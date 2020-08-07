package playground.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("myEventBus");

        eventBus.register(new MyEventListener());
        eventBus.register(new IntEventListener());
        eventBus.register(new DeadEventListener());

        eventBus.post(new MyEvent("test"));
        eventBus.post("this is dead event");
        eventBus.post(1); // dead event
    }
}
