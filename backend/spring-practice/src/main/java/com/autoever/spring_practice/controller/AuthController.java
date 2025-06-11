package com.autoever.spring_practice.controller;

import com.autoever.spring_practice.dto.LoginReqDto;
import com.autoever.spring_practice.dto.MemberReqDto;
import com.autoever.spring_practice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor // 생성자를 통한 의존성 주입을 받기 위해 생성자를 자동 지정
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    // 회원 가입 여부 확인
    @GetMapping("/exists/{email}") // 정보가 브라우저 주소창에 보여진다.
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean isExists = authService.isMember(email);
        return ResponseEntity.ok(!isExists);
    }

    // 회원 가입
    @PostMapping("/signup") // body에 정보가 보여진다.
    public ResponseEntity<Boolean> signUp(@RequestBody MemberReqDto memberReqDto) {
        boolean isSuccess = authService.signUp(memberReqDto);
        return ResponseEntity.ok(isSuccess);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginReqDto loginReqDto) {
        boolean isSuccess = authService.login(loginReqDto.getEmail(), loginReqDto.getPassword());
        return ResponseEntity.ok(isSuccess);
    }

}