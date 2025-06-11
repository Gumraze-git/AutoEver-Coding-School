package com.autoever.spring_practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class MemberReqDto {
    private String email;
    private String password;
    private String name;
}
