package com.autoever.spring_practice.repository;

import java.util.List;
import com.autoever.spring_practice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String itemName); // SELECT * FROM item WHERE item_name = ''
}
