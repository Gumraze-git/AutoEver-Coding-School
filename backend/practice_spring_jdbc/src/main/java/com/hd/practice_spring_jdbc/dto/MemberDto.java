package com.hd.practice_spring_jdbc.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@
public class MemberDto {
    private String name;
    private String email;
    private String password;
    private LocalDateTime date;
}
