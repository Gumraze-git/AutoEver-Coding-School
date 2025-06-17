package com.hd.practice_spring_jdbc.service;

import com.hd.practice_spring_jdbc.dao.MemberDao;
import com.hd.practice_spring_jdbc.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class MemberService {
    private MemberDao memberDao;
    public List<MemberDto> findAll() {
        return memberDao.findAllMembers();
    }

    // 이메일로 회원 조회
    public Optional<MemberDto> findMemberByEmail(String email) {
        Optional<MemberDto> result = memberDao.findMemberByEmail(email);
        if (result.isEmpty()) {
            throw new RuntimeException("[CUSTOM ERROR MSG] 해당 이메일이 존재하지 않습니다.");
        }
        return memberDao.findMemberByEmail(email);
    }

    // 회원 추가
    public boolean insertMember(MemberDto memberDto) {
        return memberDao.insertMember(memberDto) > 0;
    }

    // 회원 정보 수정
    public boolean updateMember(MemberDto memberDto) {
        return memberDao.updateMember(memberDto) > 0;
    }

    // 회원 정보 삭제
    public boolean deleteMember(MemberDto memberDto) {
        return memberDao.deleteMember(memberDto.getEmail()) > 0;
    }

}
