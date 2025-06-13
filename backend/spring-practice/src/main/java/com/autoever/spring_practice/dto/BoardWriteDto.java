package com.autoever.spring_practice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardWriteDto {
    private String title;   // 제목
    private String content; // 내용
    private String writer;  // 작성자
    private String img;     // 이미지
}
