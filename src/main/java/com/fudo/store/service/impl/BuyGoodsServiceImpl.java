package com.fudo.store.service.impl;

import com.fudo.store.dto.GoodsInfo;
import com.fudo.store.exception.BaseException;
import com.fudo.store.model.BuyGoods;
import com.fudo.store.repository.BuyGoodsRepo;
import com.fudo.store.service.BuyGoodsService;
import com.fudo.store.service.CommontService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyGoodsServiceImpl implements BuyGoodsService {
    @Autowired
    private BuyGoodsRepo buyGoodsRepo;
    @Autowired
    private CommontService commontService;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public com.fudo.store.model.BuyGoods save(com.fudo.store.model.BuyGoods buyGoods) {
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(buyGoods, goodsInfo);
        commontService.buyStock(goodsInfo);
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
        return buyGoodsRepo.findOne(Example.of(buyGoods, commontService.selectLikeName()))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND.getMessage()));
    }
}
