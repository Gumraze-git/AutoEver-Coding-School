package com.autoever.spring_practice.entity;

import com.autoever.spring_practice.constant.ItemsSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "item")

public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id

    @Column(nullable = false, length = 50)
    private String itemName; // 상품 이름

    @Column(nullable = false)
    private int price; // 상품 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob
    @Column(nullable = false, name = "item_description")
    private String itemDescription; // 상품 설명

    @Enumerated(EnumType.STRING)
    private ItemsSellStatus itemsSellStatus; // 상품 판매 상태

    private LocalDateTime regDate; // 등록 일시
    private LocalDateTime updateTime; // 상품 업데이트 일시
}
