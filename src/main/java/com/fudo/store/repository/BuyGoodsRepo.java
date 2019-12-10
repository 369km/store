package com.fudo.store.repository;

import com.fudo.store.model.BuyGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyGoodsRepo extends JpaRepository<BuyGoods,Integer> {
}
