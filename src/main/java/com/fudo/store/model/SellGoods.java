package com.fudo.store.model;

import javax.persistence.*;

@Entity
@Table(name = "sell_goods")
public class SellGoods extends BaseModel{
    @Column(name = "goods_id")
    private Integer goodsId;
    @Column(name = "amount")
    private Long amount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
