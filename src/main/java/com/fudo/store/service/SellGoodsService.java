package com.fudo.store.service;

import com.fudo.store.model.SellGoods;

import java.util.List;

public interface SellGoodsService {
    SellGoods save(SellGoods sellGoods);

    List<SellGoods> saveBatch(List<SellGoods> list);
}
