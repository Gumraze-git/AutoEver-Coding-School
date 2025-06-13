package com.autoever.spring_practice.repository;
import java.util.List;

import com.autoever.spring_practice.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String title);

    List<Board> findByMemberEmail(String email);

    Page<Board> findAll(Pageable pageable); // Pagination
}
