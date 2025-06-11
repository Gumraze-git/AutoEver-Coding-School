package com.autoever.spring_practice.controller;

import com.autoever.spring_practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {
        "http://localhost:3000"
        , "http://localhost:5173"
})
public class MemberController {
    private final MemberService memberService;
    // 회원 전체 조회

    // 회원 상제 조회

    // 회원 정보 조회

    // 회원 삭제

}
