package com.hd.practice_spring_jdbc.dao;

import com.hd.practice_spring_jdbc.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor // final 또는 @NotNull이 붙은 필드에 생성자를 자동으로 생성함.
@Slf4j
public class MemberDao {
    private final JdbcTemplate jdbcTemplate; // JDBC Template 의존성 주입

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

    // 전체 회원 조회 메서드
    public List<MemberDto> findAllMembers() {
        return jdbcTemplate.query(SELECT_ALL_MEMBERS, new MemberRowMapper());
    }

    //
    private static class MemberRowMapper implements RowMapper<MemberDto> {
        @Override
        public MemberDto mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            return new MemberDto(
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getTimestamp("reg_date").toLocalDateTime()
            );
        }
    }
}
