package com.autoever.spring_practice.repository;

import com.autoever.spring_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JPA Repository 인터페이스를 상속하여 Member 엔티티를 대상으로 id가 Long 타입인 CRUD 기능을 제공한다.
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일 존재 여부 확인
    boolean existsByEmail(String email);

    // 이메일 주소로 회원 정보를 조회
    Optional<Member> findByEmail(String email);

    // 이메일과 비밀번호를 이용하여 회원 정보를 조회하며, 로그인 인증에 사용된다.
    Optional<Member> findByEmailAndPassword(String email, String password);
}
