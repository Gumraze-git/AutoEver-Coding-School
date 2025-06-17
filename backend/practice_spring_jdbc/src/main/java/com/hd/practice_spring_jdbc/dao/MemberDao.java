package com.hd.practice_spring_jdbc.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private JdbcTemplate jdbcTemplate; // JDBC Template 의존성 주입

    // SQL문 작성
    // 전체 회원 조회
    private static final String SELECT_ALL_MEMBERS = "SELECT * FROM MINI_MEMBER";

    // 이메일로 회원 조회
    public static final String SELECT_MEMBER_BY_EMAIL = "SELECT * FROM MINI_MEMBER WHERE EMAIL = ?";

    // 회원 등록
    public static final String INSERT_MEMBER = "INSERT INTO MINI_MEMBER (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";

    // 회원 수정
    public static final String UPDATE_MEMBER = "UPDATE MINI_MEMBER SET PASSWORD = ?, NAME = ? WHERE EMAIL = ?";

    // 회원 삭제
    public static final String DELETE_MEMBER = "DELETE FROM MINI_MEMBER WHERE EMAIL = ?";
}
