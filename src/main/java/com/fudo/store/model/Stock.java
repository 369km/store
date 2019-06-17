package com.fudo.store.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "goods_id")
    private Integer goodsId;
    @Column(name = "total")
    private Long total;
    @Column(name = "remains")
    private Long remains;
    @Column(name = "sells")
    private Long sells;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "profit")
    private BigDecimal profit;
}
