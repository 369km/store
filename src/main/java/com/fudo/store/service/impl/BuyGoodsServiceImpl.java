package com.fudo.store.service.impl;

import com.fudo.store.repository.BuyGoodsRepo;
import com.fudo.store.service.BuyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyGoodsServiceImpl implements BuyGoodsService {
    @Autowired
    private BuyGoodsRepo buyGoodsRepo;


    @Transactional
    @Override
    public com.fudo.store.model.BuyGoods save(com.fudo.store.model.BuyGoods buyGoods) {
        return buyGoodsRepo.save(buyGoods);
    }

    @Transactional
    @Override
    public List<com.fudo.store.model.BuyGoods> saveBatch(List<com.fudo.store.model.BuyGoods> list) {
        return buyGoodsRepo.saveAll(list);
    }
}