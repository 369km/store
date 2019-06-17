package com.fudo.store.model;

import javax.persistence.*;

@Entity
@Table(name = "buy_goods")
public class BuyGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "goods_id")
    private Integer goodsId;
    @Column(name = "amount")
    private Long amount;
}
