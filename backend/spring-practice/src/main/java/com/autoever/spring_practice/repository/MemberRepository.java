package com.autoever.spring_practice.repository;

import com.autoever.spring_practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
