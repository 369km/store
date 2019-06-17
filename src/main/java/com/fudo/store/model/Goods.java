package com.fudo.store.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "specs")
    private String specs;
    @Column(name = "buy_price")
    private BigDecimal buyPrice;
    @Column(name = "sell_price")
    private BigDecimal sellPrice;
}
