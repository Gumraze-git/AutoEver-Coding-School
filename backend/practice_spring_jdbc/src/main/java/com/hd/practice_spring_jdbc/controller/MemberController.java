package com.hd.practice_spring_jdbc.controller;

import com.hd.practice_spring_jdbc.dto.MemberDto;
import com.hd.practice_spring_jdbc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
}
