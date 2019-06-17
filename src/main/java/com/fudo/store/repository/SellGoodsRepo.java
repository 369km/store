package com.fudo.store.repository;

import com.fudo.store.model.SellGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellGoodsRepo extends JpaRepository<SellGoods,Integer> {
}
