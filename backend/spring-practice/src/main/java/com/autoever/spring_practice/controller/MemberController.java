package com.autoever.spring_practice.controller;

import com.autoever.spring_practice.dto.MemberReqDto;
import com.autoever.spring_practice.dto.MemberResDto;
import com.autoever.spring_practice.repository.MemberRepository;
import com.autoever.spring_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController  // Rest API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor  // 생성자를 통한 의존성 주입을 받기위해서 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/users")
public class MemberController {
    private final MemberService memberService;

    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberResDto>> getMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    // 회원 상세 조회
    @GetMapping("/detail/{email}")
    public ResponseEntity<MemberResDto> getMember(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findByEmail(email));
    }

    // 회원 정보 수정
    @PutMapping("/modify")
    public ResponseEntity<Boolean> updateMember(@RequestBody MemberResDto memberResDto) {
        return ResponseEntity.ok(memberService.modifyMember(memberResDto));
    }

    // 회원 삭제
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable String email) {
        return ResponseEntity.ok(memberService.deleteMember(email));
    }
}