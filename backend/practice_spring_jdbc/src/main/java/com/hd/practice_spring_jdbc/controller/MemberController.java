package com.hd.practice_spring_jdbc.controller;

import com.hd.practice_spring_jdbc.dto.MemberDto;
import com.hd.practice_spring_jdbc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // JSON 응답을 위한 컨트롤러
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 전체 회원 조회
    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    // 이메일로 회원 조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMemberByEmail(@PathVariable String email) {
        Optional<MemberDto> result = memberService.findMemberByEmail(email);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 회원 등록
    @PostMapping
    public ResponseEntity<String> insertMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.insertMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 등록 성공");
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 등록 실패");
        }
    }

    // 회원 정보 수정
    @PutMapping
    public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.updateMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 정보 수정 성공");
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 수정 실패");
        }
    }
}
