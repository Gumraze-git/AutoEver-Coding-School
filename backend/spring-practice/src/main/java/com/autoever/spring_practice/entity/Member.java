package com.autoever.spring_practice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100) // DB는 낭비가 있어서는 안되기 때문에 제한(default=255)을 직접적으로 걸어주어야 한다.
    private String name;

    @Column(nullable = false) // 비밀번호는 null이 오면 안된다는 설정
    private String password;

    @Column(unique = true, length = 150) // 이메일은 unique하며, 길이 제한(150)이 있음.
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regDate;
    @PrePersist                         // 엔티티가 DB에 저장되기 직전에 실행되는 메서드
    private void prePersist() {         // 라이프사이클 콜백 메서드
        regDate = LocalDateTime.now();  // regDate 필드에 현재 시간 자동 저장된다.
    }
}