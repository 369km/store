package com.fudo.store.service;

import com.fudo.store.model.BuyGoods;

import java.util.List;

public interface BuyGoodsService {
    BuyGoods save(BuyGoods buyGoods);

    List<BuyGoods> saveBatch(List<BuyGoods> list);
}
