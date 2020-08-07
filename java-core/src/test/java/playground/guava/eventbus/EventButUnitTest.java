package playground.guava.eventbus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventButUnitTest {
    @Test
    public void postEvent() {
        EventBus eventBus = new EventBus("myEventBus");

        eventBus.register(new StringEventListener());

        eventBus.post("TEST EVENT");
    }
}