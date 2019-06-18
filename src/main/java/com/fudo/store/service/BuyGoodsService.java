package com.fudo.store.service;

import com.fudo.store.model.BuyGoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuyGoodsService {
    BuyGoods save(BuyGoods buyGoods);

    List<BuyGoods> saveBatch(List<BuyGoods> list);

    Page<BuyGoods> findAll(Pageable pageable);

    BuyGoods findOne(BuyGoods buyGoods);
}
