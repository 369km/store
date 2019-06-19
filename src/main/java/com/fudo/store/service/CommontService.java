package com.fudo.store.service;

import com.fudo.store.dto.GoodsInfo;
import com.fudo.store.model.Stock;
import org.springframework.data.domain.ExampleMatcher;

public interface CommontService {
    ExampleMatcher selectLikeName();

    Stock buyStock(GoodsInfo goodsInfo);

    Stock sellStock(GoodsInfo goodsInfo);
}
