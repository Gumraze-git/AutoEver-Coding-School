package com.autoever.spring_practice.dto;
/* MemberRegDto
 * - 회원가입 요청 시 클라이언트로부터 전달되는 데이터를 담기 위한 데이터 전송 객채(DTO, Data Transfer Object)
 * - email: 사용자가 입력한 이메일 주소
 * - password: 사용자가 입력한 비밀번호
 * - name: 사용자가 입력한 이름
 * */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SignUpReqDto {
    private String email;
    private String password;
    private String name;
}