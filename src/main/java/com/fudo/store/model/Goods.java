package com.fudo.store.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "goods")
public class Goods extends BaseModel {
    @Column(name = "name")
    private String name;
    @Column(name = "specs")
    private String specs;
    @Column(name = "buy_price")
    private BigDecimal buyPrice;
    @Column(name = "sell_price")
    private BigDecimal sellPrice;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "modify_time")
    protected LocalDateTime modifyTime = LocalDateTime.now();

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

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (!name.equals(goods.name)) return false;
        return specs.equals(goods.specs);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + specs.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", specs='" + specs + '\'' +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", modifyTime=" + modifyTime +
                ", id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
