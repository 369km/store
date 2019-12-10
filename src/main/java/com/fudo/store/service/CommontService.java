package com.fudo.store.service;

import com.fudo.store.model.BuyGoods;
import com.fudo.store.model.SellGoods;
import com.fudo.store.model.Stock;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

public interface CommontService {
    ExampleMatcher selectLikeName();

    Stock buyStock(BuyGoods buyGoods);

    List<Stock> buyStockBatch(List<BuyGoods> list);

    Stock sellStock(SellGoods sellGoods);

    List<Stock> sellStockBatch(List<SellGoods> list);
}
