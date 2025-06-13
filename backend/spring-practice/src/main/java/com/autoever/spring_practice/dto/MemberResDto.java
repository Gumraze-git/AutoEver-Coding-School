package com.autoever.spring_practice.dto;

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