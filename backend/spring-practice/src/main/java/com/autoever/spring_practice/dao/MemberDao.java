package com.autoever.spring_practice.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private final JdbcTemplate jdbcTemplate; // jdbc 의존성 주입

    // 전체 회원 조회
    private static final String SELECT_MEMBER_ALL = "SELECT * FROM member";
}
