package com.autoever.spring_practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardResDto {
    private Long id;
    private String title;
    private String content;
    private String writerEmail;
    private String img;
    private LocalDateTime createTime;
}
