package playground.cloning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member implements Cloneable {
    private String name;
    private int age;
    private Address address;

    @Override
    public Member clone() {
        try {
            Address clonedAddress = address.clone();
            Member clonedMember = (Member) super.clone();
            clonedMember.setAddress(clonedAddress);
            return clonedMember;
        } catch (CloneNotSupportedException e) {
            // Cloneable을 구현했기 때문에 이 블록이 실행되는 일은 없다.
            return null;
        }
    }
}
