package com.autoever.spring_practice.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
// 인증에 실패하면 401 Unauthorized 에러를 리턴한다.
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence
            (
                    HttpServletRequest request,
                    HttpServletResponse response,
                    AuthenticationException authException
            ) throws IOException {
        // 유효한 자격증명을 제공하지 않고 접근하려 할 때 401
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

}
