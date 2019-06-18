package com.fudo.store.service;

import com.fudo.store.model.SellGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SellGoodsService {
    SellGoods save(SellGoods sellGoods);

    List<SellGoods> saveBatch(List<SellGoods> list);

    Page<SellGoods> findAll(Pageable pageable);

    SellGoods findOne(SellGoods sellGoods);
}
