USE shop_db;

-- 기존 테이블 삭제
DROP TABLE IF EXISTS buy;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS member_ex1;
DROP TABLE IF EXISTS test_data_format;

-- 테이블 생성
CREATE TABLE test_data_format (
                                  tiny_col TINYINT,
                                  small_col SMALLINT,
                                  int_col INT,
                                  big_col BIGINT
);

INSERT INTO test_data_format VALUES (127, 32767, 123522, 90000);

CREATE TABLE member_ex1 (
                            mem_id CHAR(8) PRIMARY KEY,
                            mem_name VARCHAR(10) NOT NULL,
                            mem_number INT NOT NULL,
                            addr CHAR(2) NOT NULL,
                            phone1 CHAR(3),
                            phone2 CHAR(8),
                            height SMALLINT,
                            debut_date DATE
);

CREATE TABLE movie (
                       movie_id       INT,
                       movie_title    VARCHAR(30),
                       movie_director VARCHAR(20),
                       movie_star     VARCHAR(20),
                       movie_script   LONGTEXT,
                       movie_film     LONGBLOB
);

CREATE TABLE buy (
                     mem_id CHAR(8),
                     prd_name VARCHAR(20),
                     FOREIGN KEY (mem_id) REFERENCES member_ex1(mem_id)
);

-- 조인 예시
SELECT
    buy.mem_id,
    member_ex1.mem_name,
    buy.prd_name,
    member_ex1.addr,
    CONCAT(member_ex1.phone1, member_ex1.phone2) AS phone_book
FROM
    buy
        INNER JOIN
    member_ex1 ON buy.mem_id = member_ex1.mem_id;

-- 외부 조인
SELECT
    M.mem_id,
    M.mem_name,
    B.prd_name,
    M.addr
FROM member_ex1 M
         LEFT JOIN buy B
                   ON M.mem_id = B.mem_id
ORDER BY M.mem_id;

SELECT DISTINCT M.mem_id,
                M.mem_name,
                M.addr
FROM member_ex1 M
         LEFT JOIN buy B
                   ON M.mem_id = B.mem_id
WHERE B.prd_name IS NULL
ORDER BY M.mem_id;

-- SELF JOIN(자체 조인): 같은 테이블을 두 번 참조하여 서로 다른 역할로 조인하는 방식
CREATE TABLE self_member
(
    member_id   int primary key,
    member_name varchar(20) not null,
    leader_id   int,
    foreign key (leader_id) REFERENCES self_member (member_id)
);

INSERT INTO self_member (member_id, member_name, leader_id)
values (1, "아이린", null),
       (2, "슬기", 1),
       (3, "태연", null),
       (4,"윤아", 1);

SELECT M.member_name as 맴버,
       L.member_name as 리더
FROM self_member M
         join self_member L
              On M.leader_id = L.member_id;







