package com.autoever.spring_practice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class MemberResDto {
    private String email;
    private String name;
    private String password;
    private String image;
    private LocalDateTime regDate;
}