package com.autoever.spring_practice.service;

import com.autoever.spring_practice.dto.MemberReqDto;
import com.autoever.spring_practice.dto.TokenDto;
import com.autoever.spring_practice.entity.Member;
import com.autoever.spring_practice.jwt.TokenProvider;
import com.autoever.spring_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class AuthService {
    private final MemberRepository memberRepository; // 생성자를 통해 의존성 주입 받음.
    private final TokenProvider tokenProvider;

    // MemberReqDto를 Member 엔티티로 수동 매핑함.
    private Member convertDtoToEntity(MemberReqDto memberReqDto) {
        Member member = new Member();
        member.setEmail(memberReqDto.getEmail());
        member.setPassword(memberReqDto.getPassword());
        member.setName(memberReqDto.getName());
        return member;
    }

    // 이메일로 기존 회원 여부를 조회함.
    public boolean isMember(String email) {
        return memberRepository.existsByEmail(email); // 내부적으로 MemberRepository.existsByEmail()을 호출하여 DB에 해당 이메일이 존재하는지 확인함.
    }

    // 회원가입 요청 정보를 담고 있는 DTO을 받아, Member 엔티티로 변환 후 저장함.
    public boolean signUp(MemberReqDto memberReqDto) {
        try {
            Member member = convertDtoToEntity(memberReqDto); // 회원가입 요청 정보를 담고 있는 Dto를 받아 Member 엔티티로 변환 후 저장함.
            memberRepository.save(member);
            return true;

        } catch (Exception e) { // 예외 발생 false를 반환하고 로그에 오류 메시지를 출력함.
            log.error("회원 가입 시 오류 발생: {}", e.getMessage());
            return false;
        }
    }

    public TokenDto login(String email, String password) {
        Member member = memberRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다."));

        // Spring Security Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);

        // JWT 토큰 생성 및 반환
        return tokenProvider.generateTokenDto(authenticationToken);
    }
}
