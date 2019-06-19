package com.fudo.store.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
public class Stock extends BaseModel {
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
    @JsonFormat(pattern = "yyyy-mm-dd hh:MM:ss")
    @Column(name = "modify_time")
    protected LocalDateTime modifyTime = LocalDateTime.now();

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getRemains() {
        return remains;
    }

    public void setRemains(Long remains) {
        this.remains = remains;
    }

    public Long getSells() {
        return sells;
    }

    public void setSells(Long sells) {
        this.sells = sells;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
