package com.autoever.spring_practice.entity;

import com.autoever.spring_practice.constant.ItemsSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
// ToString: ToString() 오버라이드를 자동으로 해준다.
@ToString
// @Entity: 해당 클래스가 엔티티임을 나타낸다.
@Entity
// @Table: 해당 클래스가 DB Table 생성 시 생성될 이름 지정.
@Table(name = "item")

public class Item {
    // @id: 기본 키 필드 지정, 유일한 값을 가지며 n
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber; // 재고 수량, DB에서는 자동으로 snake 표기법으로 자동 변경된다.

    @Lob // 대용량 문자열 처리
    @Column(nullable = false, name = "item_description")
    private String itemDescription;

    @Enumerated(EnumType.STRING)
    private ItemsSellStatus itemsSellStatus;

    private LocalDateTime regDate;
    private LocalDateTime updateTime;
}
