package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.BuyGoods;
import com.fudo.store.repository.BuyGoodsRepo;
import com.fudo.store.service.BuyGoodsService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<BuyGoods> findAll(Pageable pageable) {
        return buyGoodsRepo.findAll(pageable);
    }

    @Override
    public BuyGoods findOne(BuyGoods buyGoods) {
        return buyGoodsRepo.findOne(Example.of(buyGoods, ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("createTime")))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND.getMessage()));
    }
}
