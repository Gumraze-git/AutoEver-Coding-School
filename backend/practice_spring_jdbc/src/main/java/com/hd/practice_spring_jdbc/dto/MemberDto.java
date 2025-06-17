package com.hd.practice_spring_jdbc.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private String name;
    private String email;
    private String password;
    private LocalDateTime date;
}
