package com.autoever.spring_practice.service;

import com.autoever.spring_practice.dto.MemberReqDto;
import com.autoever.spring_practice.entity.Member;
import com.autoever.spring_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class AuthService {
    private final MemberRepository memberRepository; // 생성자를 통해 의존성 주입받음

    // 회원 가입 여부 확인
    public boolean isMember(String email) {
        return memberRepository.existsByEmail(email);
    }

    // 회원 가입
    public boolean signUp(MemberReqDto memberReqDto) {
        try {
            Member member = convertDtoToEntity(memberReqDto);
            memberRepository.save(member);
            return true;

        } catch (Exception e) {
            log.error("회원 가입 시 오류 발생: {}", e.getMessage());
            return false;
        }
    }

    // 로그인
    public boolean login(String email, String password) {
        Optional<Member> member = memberRepository.findByEmailAndPassword(email, password);
        return member.isPresent(); // 객체 존재 여부 확인
    }

    // DTO -> Entity Mapping
    private Member convertDtoToEntity(MemberReqDto memberReqDto) {
        Member member = new Member();
        member.setEmail(memberReqDto.getEmail());
        member.setPassword(memberReqDto.getPassword());
        member.setName(memberReqDto.getName());
        return member;
    }
}
