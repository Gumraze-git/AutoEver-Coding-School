package com.autoever.spring_practice.service;

import ch.qos.logback.core.Context;
import com.autoever.spring_practice.dto.MemberReqDto;
import com.autoever.spring_practice.dto.MemberResDto;
import com.autoever.spring_practice.dto.TokenDto;
import com.autoever.spring_practice.entity.Member;
import com.autoever.spring_practice.jwt.TokenProvider;
import com.autoever.spring_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor

public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder; // 인증을 담당하는 클래스
    private final MemberRepository memberRepository; // 생성자를 통해 의존성 주입 받음.
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

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
    public MemberResDto signUp(MemberReqDto memberReqDto) {
        if (memberRepository.existsByEmail(memberReqDto.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        Member member = memberReqDto.toEntity(passwordEncoder);
        return MemberResDto.of(memberRepository.save(member));
    }

    // 로그인
    public TokenDto login(MemberReqDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);
    }
}
