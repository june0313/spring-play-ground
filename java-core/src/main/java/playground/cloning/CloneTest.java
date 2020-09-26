package playground.cloning;

public class CloneTest {
    public static void main(String[] args) {
        Member member1 = new Member("wayne", 31, new Address(10101, "seoul"));
        Member member2 = member1.clone();

        Address address1 = member1.getAddress();
        Address address2 = member2.getAddress();

        // address2 객체의 상태를 변경한다
        address2.setCity("busan");

        System.out.printf("address1 hashcode : %s, city : %s\n", address1, address1.getCity());
        System.out.printf("address2 hashcode : %s, city : %s\n", address2, address2.getCity());
    }
}
