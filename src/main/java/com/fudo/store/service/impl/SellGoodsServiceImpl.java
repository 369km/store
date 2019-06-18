package com.fudo.store.service.impl;

import com.fudo.store.model.SellGoods;
import com.fudo.store.repository.SellGoodsRepo;
import com.fudo.store.service.SellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellGoodsServiceImpl implements SellGoodsService {
    @Autowired
    private SellGoodsRepo sellGoodsRepo;

    @Override
    public SellGoods save(SellGoods sellGoods) {
        return sellGoodsRepo.save(sellGoods);
    }

    @Override
    public List<SellGoods> saveBatch(List<SellGoods> list) {
        return sellGoodsRepo.saveAll(list);
    }
}
