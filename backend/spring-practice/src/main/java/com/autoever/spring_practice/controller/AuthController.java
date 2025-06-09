package com.autoever.spring_practice.controller;
/*
 * DTO: Data Transfer Object
 * MemberRegDto: 사용자로부터 전달받는 요청 데이터
 * MemberRestDto: 응답으로 반환할 데이터
 * */

import com.autoever.spring_practice.dto.MemberRegDto;
import com.autoever.spring_practice.dto.MemberResDto;
// Slf4j: Lombok이 제공하는 어노테이션으로 log.info(), log.error() 등의 로그 출력을 위한 Logger 인스턴스를 자동 생성한다.
import lombok.extern.slf4j.Slf4j;
// ResponseEntity: HTTP 응답을 보다 명확하게 구성할 수 있도록 해주는 클래스
import org.springframework.http.ResponseEntity;
// @RestController, @PostMapping, @RequestBody 등의 어노테이션 사용을 위해 Spring Web MVC 관련 클래스들을 가져옵니다.
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime; // 등록일자 필드 설정을 위한 시간 정보 클래스
import java.util.ArrayList;
import java.util.List;

@Slf4j                          // Log 메시지 출력을 위한 어노테이션
@RestController                 // 이 클래스가 REST API 컨트롤러임을 나타낸다.
@RequestMapping("/auth")        // 컨트롤러의 기본 URL 경로를 /auth로 지정함. 하위 모든 요청 경로는 이 경로를 기반으로 한다.
public class AuthController {   // 인증 및 회원가입과 관련된 요청을 처리하는 컨트롤러
    /* signup controller(POST)
     * 회원가입 시 요청(Request)을 받아 응답(Response)를 보내는 기본 구조를 정의하는 컨트롤러 메서드임.
     * 클라이언트가 보낸 데이터를 서버에서 수신하고, 이를 가공하여 응답 객체에 담아 반환함.
     * */    @PostMapping("signup")
    // 클라이언트에서 전송된 JSON 요청 데이터를 MemberRegDto 객체로 변환하여 받음.
    // 반환 타입은 ResponseEntity<MemberResDto>로, HTTP 상태 코드와 함께 응답 데이터틑 받는다.
    // @RequestBody: HTTP 요청 본문(body)를 java 객체로 변환해주는 역할을 한다.
    public ResponseEntity<MemberResDto> signup(@RequestBody MemberRegDto memberRegDto) {
        log.info("member : {}", memberRegDto);  // 받은 회원 가입 요청 내용을 서버 로그에 기록함.

        // 응답에 사용할 MemberResDto 객체 생성
        MemberResDto memberResDto = new MemberResDto();

        // 요청으로 받은 정보(email, name, pwd, image, regdate)를 응답 DTO에 복사함.
        memberResDto.setEmail(memberRegDto.getEmail());
        memberResDto.setName(memberRegDto.getName());
        memberResDto.setPassword(memberRegDto.getPassword());
        memberResDto.setImage("test/test.img");
        memberResDto.setRegDate(LocalDateTime.now());

        // HTTP 응답 200 OK와 함께 DTO를 반환한다.
        return ResponseEntity.ok(memberResDto);
    }

    /* Login controller(POST)
     * - 클라이언트가 `/auth/login` 경로로 보낸 로그인 요청을 받아 인증 여부를 boolean으로 응답함.
     * - Post 방식: email, password를 Request Body 형식으로 수신
     * - Request Body 형식: HTTP 요청 메시지의 본문(body)에 데이터를 담아 전송하는 방식
     */
    // HTTP POST 요청 중 "/auth/login" 경로로 들어오는 요청을 처리함.
    @PostMapping("/login")

    // 클라이언트가 전송한 JSON 데이터를 MemberRegDto 객체로 매핑함.
    // 응답은 ResponseEntity<Boolean> 타입으로 HTTP 상태와 함께 boolean을 반환함.
    public ResponseEntity<Boolean> login(@RequestBody MemberRegDto memberRegDto) {
        log.info("member : {}", memberRegDto);          // 전달받은 로그인 요청 정보를 로그에 출력한다.

        // 임의의 인증 로직으로 이메일과 비밀번호가 다음 예시와 동일하면 성공
        boolean isAuthenticated =
                "test@example.com".equals(memberRegDto.getEmail()) &&
                        "1234".equals(memberRegDto.getPassword());

        // 인증 결과를 HTTP 200 OK 상태와 함께 응답 본문으로 반환한다.
        return ResponseEntity.ok(isAuthenticated);
    }

    /* member check controller(GET)
     * 특정 이메일이 있다면 해당 회원 정보를, 없다면 전체 회원 목록을 반환하는 API     * 단, 회원 정보 리스트는 서비스 로직과 DB가 없으므로, for문으로 자체 생성
     * */
    // HTTP GET 요청 `/auth/members`에 대해 이 메서드가 실행됨.
    @GetMapping("/members")

    // 쿼리 파라미터 email을 받을 수 있도록 설정, 필수가 아니므로
    public ResponseEntity<?> getMembers(@RequestParam(required = false) String email) {
    // DB 대신 사용할 더미 리스트 객체 초기화
    List<MemberResDto> dummyList = new ArrayList<>();

    // 더미 리스트 생성
        for (int i = 1; i <= 3; i++) {
        dummyList.add(new MemberResDto(
                "user_" + i + "@example.com",
                "UserName_" + i,
                "pwd_" + i,
                "image_" + i + ".png",
                LocalDateTime.now()
        ));
    }

    // 쿼리 파라미터로 이메일이 들어오면 해당 이메일에 일치하는 회원을 찾아 응답함.
        if (email != null) {
        // 이메일로 회원 검색
        return dummyList.stream().filter((m -> m.getEmail().equals(email)))
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)     // Optional에 값이 있는 경우 해당 값을 ResponseEntity.ok(...)로 반환
                .orElse(ResponseEntity.notFound().build());     // Optional에 값이 없을 경우, ResponseEntity.notFound.build()를 반환
    } else {
        // 전체 회원 반환
        return ResponseEntity.ok(dummyList);
    }
}
}