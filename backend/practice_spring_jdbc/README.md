# 설정
```properties
server.port=8111

spring.datasource.url=jdbc:mysql://localhost:3306/autoever_jpa_mysql_0605
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=4109
```

# 프로젝트 구조
```text
practice_spring_jdbc/
├── src/main/
│   ├── java/com/hd/practice_spring_jdbc
│   │   ├── dao/
│   │   │   └── MemberDao.java            # DAO 계층: JDBC를 통한 DB 접근
│   │   └── dto/
│   │       └── MemberDto.java            # DTO 클래스: 회원 데이터 전달 객체
│   └── resources/
│       └── application.properties        # 데이터베이스 설정 등 환경 설정
└── build.gradle
```

## MemberDto
```java
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
```

## MemberDao
#### 의존성 필드
```java
private JdbcTemplate jdbcTemplate; 
```
- Spring JDBC에서 사용하는 핵심 객체이다.
  - SQL 실행, 바인딩, 예외처리를 간단하게 해주는 도구이다.
  
#### SQL 상수 선언
```java
private static final String SELECT_ALL_MEMBERS = "SELECT * FROM MINI_MEMBER";
public static final String SELECT_MEMBER_BY_EMAIL = "SELECT * FROM MINI_MEMBER WHERE EMAIL = ?";
public static final String INSERT_MEMBER = "INSERT INTO MINI_MEMBER (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
public static final String UPDATE_MEMBER = "UPDATE MINI_MEMBER SET PASSWORD = ?, NAME = ? WHERE EMAIL = ?";
public static final String DELETE_MEMBER = "DELETE FROM MINI_MEMBER WHERE EMAIL = ?";
```
- 반복적으로 사용하는 SQL 구문을 상수로 정의하여 관리한다.

#### 기능별 메서드
##### 1. 전체 회원 조회
```java
public List<MemberDto> findAllMembers() {
    return jdbcTemplate.query(SELECT_ALL_MEMBERS, new MemberRowMapper());
}
```
- 전체 회원 조회 메서드로 `jdbcTemplate.query(...)`는 SQL 실행 후 레코드를 리스트로 반환한다.
- `MemberRowMapper`는 `ResultSet`을 `MemberDto`객체로 매핑한다.

##### 2. 이메일로 회원 조회
```java
public Optional<MemberDto> findMemberByEmail(String email) {
  List<MemberDto> result = jdbcTemplate.query(SELECT_MEMBER_BY_EMAIL, new MemberRowMapper(), email);
  return result.stream().findFirst(); // 비어 있으면 Optional.empty()
}
```
- 주어진 이메일을 기준으로 MINI_MEMBER 테이블에서 해당 회원을 조회한다.
- 이메일은 일반적으로 유일값이며, 데이터가 존재하지 않을 수도 있기 때문에 `Optional<MemberDto>`를 사용한다.

##### 3. 회원 등록
```java
public int insertMember(MemberDto memberDto) {
    return jdbcTemplate.update(INSERT_MEMBER, memberDto.getName(), memberDto.getEmail(), memberDto.getPassword());
}
```
- `INSERT INTO` 쿼리를 통해 새로운 회원을 등록한다.
- 반환값은 삽인된 레코드 수(`int`)이다.

##### 4. 회원 수정
```java
public int updateMember(MemberDto memberDto) {
    return jdbcTemplate.update(UPDATE_MEMBER, memberDto.getPassword(), memberDto.getName(), memberDto.getEmail());
}
```
- 기존 이메일을 기준으로 이름과 비밀번호를 수정한다.
- `UDATE` 쿼리 이므로 반환값은 수정된 행의 수(`int`)이다.

##### 5. 회원 삭제
```java
public boolean deleteMember(String email) {
    return jdbcTemplate.update(DELETE_MEMBER, email) > 0;
}
```
- `String` 이메일을 입력 받아 `DELETE_MEMBER` 쿼리 실행한다.

#### 내부 클래스: MemberRowMapper
```java
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
```
- JDBC 결과인 `ResultSet`에서 하나의 행(`row`)을 읽어 `MemeberDto` 객체로 매핑한다.
- 이 클래스는 `RowMapper<T>` 인터페이스를 구현하며, `query()`에서 호출한다.

**전체 코드**
```java
@Repository // Spring이 이 클래스를 DAO로 인식하여 빈으로 등록하여 SQL 예외를 DataAccessException으로 반환함.
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

  // 이메일로 회원 조회 메서드
  public Optional<MemberDto> findMemberByEmail(String email) {
    List<MemberDto> result = jdbcTemplate.query(SELECT_MEMBER_BY_EMAIL, new MemberRowMapper(), email);
    return result.stream().findFirst(); // 비어 있으면 Optional.empty()
  }

  // 회원 등록 메서드
  public int insertMember(MemberDto memberDto) {
    return jdbcTemplate.update(INSERT_MEMBER, memberDto.getName(), memberDto.getEmail(), memberDto.getPassword());
  }

  // 회원 수정 메서드
  public int updateMember(MemberDto memberDto) {
    return jdbcTemplate.update(UPDATE_MEMBER, memberDto.getPassword(), memberDto.getName(), memberDto.getEmail());
  }

  // 회원 삭제 메서드
  public boolean deleteMember(String email) {
    return jdbcTemplate.update(DELETE_MEMBER, email) > 0;
  }

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
```

## Controller
### MemberController
#### [GET] 전체 회원 조회 API
```java
@GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }
```
- 모든 회원 정보를 조회하여 JSON 배열로 응답한다.

#### [GET] 이메일로 특정 회원 조회 API
```java
@GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMemberByEmail(@PathVariable String email) {
        Optional<MemberDto> result = memberService.findMemberByEmail(email);
        return result.map(ResponseEntity::ok) // 회원이 존재하면 200 OK + JSON 반환
                .orElse(ResponseEntity.notFound().build()); // 존재하지 않으면 404 Not Found
    }
```
- 이메일을 기준으로 회원 한 명을 조회, 없으면 `404`를 반환한다.

#### [POST] 회원 등록 API
```java
@PostMapping
    public ResponseEntity<String> insertMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.insertMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 등록 성공"); // 200 OK
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 등록 실패"); // 400 Bad Request
        }
    }
```
- `@RequestBody`로 전달된 JSON 데이터를 기반으로 회원 등록을 시도한다.

#### [PUT] 회원 정보 수정 API
```java
@PutMapping
    public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.updateMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 정보 수정 성공"); // 200 OK
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 수정 실패"); // 400 Bad Request
        }
    }
```
- 전달된 회원 정보(JSON)을 기반으로 이름 및 비밀번호를 수정한다.

#### [DELETE] 회원 삭제 API
```java
public ResponseEntity<String> deleteMember(@PathVariable String email) {
        boolean success = memberService.deleteMember(email);
        if (success) {
            return ResponseEntity.ok("회원 삭제 성공"); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
```
- 이메일을 기준으로 회원을 삭제한다.
- 성공 시 `200`, 실패 시 `404`를 반환한다.

#### 전체 코드
```java
@RestController // JSON 응답을 위한 컨트롤러
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 전체 회원 조회
    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    // 이메일로 회원 조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMemberByEmail(@PathVariable String email) {
        Optional<MemberDto> result = memberService.findMemberByEmail(email);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 회원 등록
    @PostMapping
    public ResponseEntity<String> insertMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.insertMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 등록 성공");
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 등록 실패");
        }
    }

    // 회원 정보 수정
    @PutMapping
    public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) {
        boolean success = memberService.updateMember(memberDto);
        if (success) {
            return ResponseEntity.ok("[CUSTOM MSG] 회원 정보 수정 성공");
        } else {
            return ResponseEntity.badRequest().body("[CUSTOM MSG] 회원 수정 실패");
        }
    }

    // 회원 삭제
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteMember(@PathVariable String email) {
        boolean success = memberService.deleteMember(email);
        if (success) {
            return ResponseEntity.ok("회원 삭제 성공");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```
