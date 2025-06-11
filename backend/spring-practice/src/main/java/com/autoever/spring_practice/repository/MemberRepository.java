package com.autoever.spring_practice.repository;

import com.autoever.spring_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일 존재 여부 확인
    boolean existsByEmail(String email);

    // 이메일로 회원 정보 가져오기
    // Optional: null을 처리하기 위해 사용한다.
    Optional<Member> findByEmail(String email);

    // 로그인 성공 실패를 위해서 email과 pwd가 존재하는지 확인
    Optional<Member> findByEmailAndPassword(String email, String password);

    String password(String password);
}
