package com.hd.practice_spring_jdbc.controller;

import com.hd.practice_spring_jdbc.dto.MemberDto;
import com.hd.practice_spring_jdbc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
