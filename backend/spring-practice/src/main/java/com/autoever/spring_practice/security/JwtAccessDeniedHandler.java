package com.autoever.spring_practice.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle
            (HttpServletRequest request,
             HttpServletResponse response,
             AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        // 필요한 권한이 없이 접근하려 할 때 403 에러 발생
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
    }
}
