package com.fudo.store.repository;

import com.fudo.store.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepo extends JpaRepository<Goods, Integer> {
    Goods findByNameAndSpecs(String name,String specs);
}
