package com.autoever.spring_practice.repository;

import java.util.List;
import com.autoever.spring_practice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// @Repository: 해당 인터페이스가 데이터 접근 계층이라는 것을 Spring에 알려주는 애너테이션
@Repository
// ItemRepository는 Item 엔티티를 다루며, 기본 키는 Long이다.
// jpaRepository를 상속하면 save, findById, delete와 같은 CRUD 메서드를 자동으로 사용할 수 있다.
public interface ItemRepository extends JpaRepository<Item, Long> {

    // 메서드 이름 기반의 JPA 쿼리 메서드이다.
    // item_name 컬럼이 주어진 itemName과 일치하는 Item 목록을 반환한다.
    // 다음 쿼리 문이 실행된다. SELECT * FROM item WHERE item_name = :itemName;
    List<Item> findByItemName(String itemName);

    // 다음 쿼리 문이 반환된다.
    // SELECT * FROM item WHERE item_name = :itemName OR item_description = :itemDescription;
    List<Item> findByItemNameOrItemDescription(String itemName, String itemDescription);

    // 실제 쿼리 메시지를 만들고 보내는 방법 2가지
    // @Query: JPQL, nativeQuery
    // JPQL: OOP 언어로 쿼리를 작성하는 언어이다.
    @Query("SELECT i FROM Item i WHERE i.itemDescription like %:itemDescription% ORDER BY i.price desc")
    List<Item> findByItemDescription(@Param("ItemDescription") String itemDescription);
}
