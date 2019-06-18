package com.fudo.store.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "goods")
public class Goods extends BaseModel{
    @Column(name = "name")
    private String name;
    @Column(name = "specs")
    private String specs;
    @Column(name = "buy_price")
    private BigDecimal buyPrice;
    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
