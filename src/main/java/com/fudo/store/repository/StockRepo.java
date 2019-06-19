package com.fudo.store.repository;

import com.fudo.store.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
    Stock findByGoodsId(Integer goodsId);
}
