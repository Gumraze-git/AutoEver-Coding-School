package com.autoever.spring_practice.entity;
// Spring Boot + JPA 환경에서 사용되는 Member entity 클래스 생성
// DB의 member 테이블과 매핑되어 사용자 정보를 저장하기 위한 도메인 모델이다.
// 목적: 회원 이름, 비밀번호, 이메일, 프로필 이미지 등을 DB에 저장하고 관리한다.

// Lombok 라이브러리에서 제공하는 어노테이션
import lombok.Getter;               // 모든 필드에 대해 getter 메서드 자동 생성
import lombok.Setter;               // 모든 필드에 대해 setter 메서드 자동 생성
import lombok.NoArgsConstructor;    // 기본 생성자(파라미터 없는) 자동 생성

// JPA 관련 어노테이션 호출
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity                             // 이 클래스가 JPA 엔티티임을 나타낸다.
@Table(name = "member")             // 이 엔티티는 DB의 "member"라는 이름의 테이블에 매핑된다. 기본적으로 클래스 이름이 테이블 이름이 된다.
@Getter @Setter                     // 클래스의 모든 필드에 대해 getter/setter 메서드를 자동 생성한다.
@NoArgsConstructor                  // 기본 생성자(public Member() {})를 자동 생성한다.
public class Member {
    @Id                             // 기본 키(primary key)로 지정하여 DB에서 기록을 고유하게 식별하는 키이다.
    @GeneratedValue(strategy = GenerationType.AUTO)     // 자동 생성 전략을 지정
    @Column(name = "member_id")     // DB 컬럼명을 "member_id"로 명시함.
    private Long id;

    @Column(length = 100)               // DB는 낭비가 있어서는 안되기 때문에 제한(default=255)을 직접적으로 걸어주어야 한다.
    private String name;

    @Column(nullable = false)           // 비밀번호는 null이 오면 안된다는 설정
    private String password;

    @Column(unique = true, length = 150)          // 이메일은 unique하며, 길이 제한(150)이 있음.
    private String email;

    @Column(length = 255)
    private String image;

    private LocalDateTime regDate;
    @PrePersist                         // 엔티티가 DB에 저장되기 직전에 실행되는 메서드
    private void prePersist() {         // 라이프사이클 콜백 메서드
        regDate = LocalDateTime.now();  // regDate 필드에 현재 시간 자동 저장된다.
    }
}