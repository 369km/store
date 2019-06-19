package com.fudo.store.repository;

import com.fudo.store.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
    Stock findByGoodsId(Integer goodsId);

    List<Stock> findByGoodsIdIn(List<Integer> list);
}
