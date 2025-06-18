package com.autoever.spring_practice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    private SecurityUtil() {}
    public static long getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("Authentication is null or name is null");
        }
        return Long.parseLong(authentication.getName());
    }
}
