package playground.modernjava.concurrency;

import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        Spliterator<HelloPerson> spliterator = HelloPerson.getSampleData().spliterator();
        spliterator.forEachRemaining((person) -> System.out.printf("안녕~~ %s\n", person));
    }
}
