package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name; // api에서 key바꿀려면 변수명도 바꿔야하는 문제 발생, Entity 종속적임 -> 별도의 dto를 만들어야함

    @Embedded
    private Address address;

    // @JsonIgnore
    @OneToMany(mappedBy = "member") // readonly
    private List<Order> orders = new ArrayList<>();

}
