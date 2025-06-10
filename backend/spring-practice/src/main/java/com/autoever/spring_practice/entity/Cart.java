package com.autoever.spring_practice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // cart에 대한 id 생성

    @Column(nullable = false, length = 50)
    private String cartName;

    @OneToOne // Member entity와 1대1 매핑
    @JoinColumn(name = "member_id")
    private Member member; // 생성된 회원 객체가 와야 한다.
}
