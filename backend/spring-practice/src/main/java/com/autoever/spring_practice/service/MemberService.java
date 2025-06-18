package com.autoever.spring_practice.service;

import java.util.List;
import com.autoever.spring_practice.dto.MemberResDto;
import com.autoever.spring_practice.entity.Member;
import com.autoever.spring_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;
    private final MemberRepository memberRepository;

    // 회원 전체 조회
    public List<MemberResDto> findAll() {
        List<Member> members = memberRepository.findAll(); // DB의 정보를 Member Entity에 담음
        List<MemberResDto> memberResDtoList = new ArrayList<>(); // Dto List 생성

        for (Member member : members) {
            memberResDtoList.add(convertEntityToDto(member));
        }
        return memberResDtoList;
    }
    // 회원 상세 조회
    public MemberResDto findByEmail(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("해당 회원이 존재하지 않습니다.")
        );
        return convertEntityToDto(member);
    }

    // 회원 정보 수정
    public boolean modifyMember(MemberResDto memberResDto) {
        try {
            Member member = memberRepository.findByEmail(memberResDto.getEmail()).orElseThrow(
                    () -> new RuntimeException("해당 회원이 존재하지 않습니다.")
            );
            member.setEmail(memberResDto.getEmail());
            memberRepository.save(member);
            return true;
        } catch (Exception e) {
            log.error("회원 정보 수정 실패: {}", e.getMessage());
            return false;
        }
    }

    // 회원 정보 삭제
    public boolean deleteMember(String email) {
        try {
            Member member = memberRepository.findByEmail(email).orElseThrow(
                    () -> new RuntimeException("해당 회원이 존재하지 않습니다.")// 500 에러
            );
            memberRepository.delete(member);
            return true;
        } catch (Exception e) {
            log.error("회원 정보 삭제 실패: {}", e.getMessage());
            return false;
        }
    }

    // Entity -> DTO에 담는 메서드
    public MemberResDto convertEntityToDto(Member member) {
        return MemberResDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .image(member.getImage())
                .regDate(member.getRegDate())
                .build();
    }
}
