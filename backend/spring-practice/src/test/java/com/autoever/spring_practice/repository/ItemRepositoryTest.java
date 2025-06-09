package com.autoever.spring_practice.repository;

import java.util.List;
import com.autoever.spring_practice.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createTest() {
        Item item = new Item();
        item.setItemName("test item");
        item.setPrice(10000);
        item.setItemDescription("test description");
        item.setStockNumber(100);
        item.setRegDate(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
    }

    @Test
    @DisplayName("상품 여러 개 저장 테스트")
    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemName("테스트 상품 " + i);
            item.setPrice(10000);
            item.setItemDescription("test description");
            item.setStockNumber(100);
            item.setRegDate(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            log.debug("Item saved : {}", savedItem);
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemName() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemName("테스트 상품 5");
        for (Item item : list) {
            log.debug("Item found : {}", item);
        }
    }
}