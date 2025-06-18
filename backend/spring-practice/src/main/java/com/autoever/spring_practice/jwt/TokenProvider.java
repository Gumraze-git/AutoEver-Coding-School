package com.autoever.spring_practice.jwt;

import com.autoever.spring_practice.dto.TokenDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TokenProvider {
    private static final String AUTHORITIES_KEY = "auth"; // 권한 정보를 저장하는 키
    private final Key key; // JWT 서명에 사용할 비밀 키

    // 비밀 키를 기반으로 키 객체 초기화
    // 주의점 @Value 애너테이션은 springframework
    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 토큰 생성 메서드
    public TokenDto generateTokenDto(Authentication authentication) {
        // 인증 객체에서 권한 정보 추출
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        // 현재 시간과 토큰 만료 시간 계산
        long now = (new Date()).getTime();
        Date accessTokenExpiresIn = new Date(now + 30 * 60 * 1000); // 30분

        // Access Token 생성
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName()) // 사용자명 설정, 이메일이 들어있음.
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        // 결과를 DTO로 반환
        return TokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .tokenExpireIn(accessTokenExpiresIn.getTime())
                .build();
    }
}
