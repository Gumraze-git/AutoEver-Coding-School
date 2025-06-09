package com.autoever.spring_practice.dto;

/* MemberResDto
 * - 회원가입 또는 회원 정보 조회 응답에 사용될 데이터 전송 객체.
 * - email: 사용자의 이메일
 * - name: 사용자의 이름
 * - password: 사용자의 비밀번호
 * - image: 사용자의 이미지
 * - regDate: 사용자 등록 시점
 * */
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MemberResDto {
    private String email;
    private String name;
    private String password;
    private String image;
    private LocalDateTime regDate;
}