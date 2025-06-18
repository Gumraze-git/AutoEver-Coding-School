package com.autoever.spring_practice.dao;

import com.autoever.spring_practice.dto.MemberResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private final JdbcTemplate jdbcTemplate; // jdbc 의존성 주입

    // 전체 회원 조회
    private static final String SELECT_MEMBER_ALL = "SELECT * FROM member";

    private static class MemberRowMapper implements RowMapper<MemberResDto> {
        @Override
        public MemberResDto mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            return new MemberResDto(
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("image"),
                    resultSet.getTimestamp("reg_date").toLocalDateTime()
                    );
        }
    }
}
