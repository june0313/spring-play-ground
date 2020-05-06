package playground.stream.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class NullSafeSortExampleTest {
    @Test
    public void sortNotNullSafe() {
        List<Member> memberList = Arrays.asList(Member.of(10), Member.of(null), Member.of(5));

        List<Member> result = memberList.stream()
                .sorted(Comparator.comparing(Member::getAge))
                .collect(toList());

        System.out.println(result);
    }

    @Test
    public void sort() {
        List<Member> memberList = Arrays.asList(Member.of(10), Member.of(5), Member.of(20));

        List<Member> sortedMemberList = memberList.stream()
                .sorted(Comparator.comparing(Member::getAge))
                .collect(toList());

        System.out.println(sortedMemberList);
    }

    @Test
    public void reverseSort() {
        List<Member> memberList = Arrays.asList(Member.of(10), Member.of(5), Member.of(20));

        List<Member> sortedMemberList = memberList.stream()
                .sorted(Comparator.comparing(Member::getAge, Comparator.reverseOrder()))
                .collect(toList());

        System.out.println(sortedMemberList);
    }

    @Test
    public void sortNullsLast() {
        List<Member> memberList = Arrays.asList(Member.of(10), Member.of(null), Member.of(5));

        List<Member> result = memberList.stream()
                .sorted(Comparator.comparing(Member::getAge, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(toList());

        System.out.println(result);
    }

    @Test
    public void sortNullsFirst() {
        List<Member> memberList = Arrays.asList(Member.of(10), Member.of(null), Member.of(5));
        List<Member> result = memberList.stream()
                .sorted(Comparator.comparing(Member::getAge, Comparator.nullsFirst(Comparator.reverseOrder())))
                .collect(toList());

        System.out.println(result);
    }
}