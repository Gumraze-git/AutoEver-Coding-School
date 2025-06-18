package com.autoever.spring_practice.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType; // 인증 방식
    private String accessToken; // 엑세스 토큰
    private String refreshToken;
    private Long accessTokenExpireIn;
    private Long refreshTokenExpireIn;
}
