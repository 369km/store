package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.SellGoods;
import com.fudo.store.repository.SellGoodsRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.service.SellGoodsService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SellGoodsServiceImpl implements SellGoodsService {
    @Autowired
    private SellGoodsRepo sellGoodsRepo;
    @Autowired
    private CommontService commontService;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public SellGoods save(SellGoods sellGoods) {
        commontService.sellStock(sellGoods);
        return sellGoodsRepo.save(sellGoods);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public List<SellGoods> saveBatch(List<SellGoods> list) {
        commontService.sellStockBatch(list);
        return sellGoodsRepo.saveAll(list);
    }

    @Override
    public Page<SellGoods> findAll(Pageable pageable) {
        return sellGoodsRepo.findAll(pageable);
    }

    @Override
    public SellGoods findOne(SellGoods sellGoods) {
        return sellGoodsRepo.findOne(Example.of(sellGoods, commontService.selectLikeName()))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND));
    }
}
