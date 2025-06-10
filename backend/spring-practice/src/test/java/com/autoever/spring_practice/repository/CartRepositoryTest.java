package com.autoever.spring_practice.repository;

import com.autoever.spring_practice.entity.Cart;
import com.autoever.spring_practice.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class CartRepositoryTest {
    @Autowired // 의존성 주입을 받는다. 생성자를 통한 의존성 주입인 경우에는 어노테이션이 필요하지 않다.
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext //JPA의 Entity Manager
    EntityManager em;

    // 회원 엔티티 생성
    public Member createMember() {
        Member member = new Member();
        member.setName("DKim");
        member.setEmail("DKim@email.com");
        member.setPassword("<PASSWORD>");
        member = memberRepository.save(member);
        return member;
    }

    @Test
    @Transactional
    @DisplayName("장바구니와 회원 매핑 조회 테스트")
    public void findCartAndMember() {
        Member member = createMember();
        memberRepository.save(member); // DB에 회원 추가

        Cart cart = new Cart();
        cart.setCartName("자동차 구매 장바구니");
        cart.setMember(member);
        cartRepository.save(cart);

        em.flush(); // 영속성 컨텍스트에 저장된 내용을 DB에 반영
        em.clear(); // 영속성 컨텍스트 메모리 비움

        Cart saveCart = cartRepository.findById(cart.getId())
                .orElseThrow(EntityNotFoundException::new);

        log.info("Cart: {}", saveCart);
    }
}