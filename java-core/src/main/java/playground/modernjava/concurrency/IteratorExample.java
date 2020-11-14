package playground.modernjava.concurrency;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleData();
        Iterator<HelloPerson> iterator = personList.iterator();
        iterator.forEachRemaining(person -> System.out.printf("안녕~~ %s\n", person));
    }
}
