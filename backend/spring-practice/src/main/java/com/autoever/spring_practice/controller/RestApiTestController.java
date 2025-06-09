package com.autoever.spring_practice.controller;

// GetMapping: 해당 클래스가 REST API 컨트롤러임을 명시함.
// PathVariable: URI 경로에 포함된 값을 메서드 파라미터로 바인딩 할 때 사용한다.
// RequestMapping: 클래스 또는 메서드 수준에서 공통 URI 경로를 정의할 때 사용한다.
// RestController: HTTP GET 요청에 대한 처리 메서드 지정
import org.springframework.web.bind.annotation.*;


@RestController                        // 클래스 내의 모든 메서드가 HTTP 응답 바디에 데이터를 직접 반환하도록 설정
@RequestMapping("/api")                 // 이 클래스의 모든 URL은 "/api"로 시작한다.(GET 방식)
public class RestApiTestController {
    @GetMapping("/hello")               // 클라이언트가 GET "/api/hello"로 요청을 보낼 경우 이 메서드가 실행된다.
    public String getHello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/board/{variable}")    // 경로에 동적 값을 포함할 수 있다.
    public String getVariable(@PathVariable String variable) {
        // {variable} 자리에 들어온 값을 메서드 파라미터 variable에 바인딩하여 그대로 반환한다.
        return variable;
    }

    // 'api/req' 경로로 들어온 GET 요청의 쿼리 파라미터를 처리한다.
    // ex) /api/req?name=DKim&email=DKim@example.com&company=Autoever    @GetMapping("/req")
    public String getRegParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company
    ) {
        // 쿼리 파라미터 값을 각각 변수에 바인딩하여 하나의 문자열로 합쳐 반환한다.
        return name + " " + email + " " + company;
    }
}



