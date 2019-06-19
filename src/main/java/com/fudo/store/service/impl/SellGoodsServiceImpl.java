package com.fudo.store.service.impl;

import com.fudo.store.dto.GoodsInfo;
import com.fudo.store.exception.BaseException;
import com.fudo.store.model.SellGoods;
import com.fudo.store.repository.SellGoodsRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.service.SellGoodsService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellGoodsServiceImpl implements SellGoodsService {
    @Autowired
    private SellGoodsRepo sellGoodsRepo;
    @Autowired
    private CommontService commontService;

    @Override
    public SellGoods save(SellGoods sellGoods) {
        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(sellGoods, goodsInfo);
        commontService.sellStock(goodsInfo);
        return sellGoodsRepo.save(sellGoods);
    }

    @Override
    public List<SellGoods> saveBatch(List<SellGoods> list) {
        return sellGoodsRepo.saveAll(list);
    }

    @Override
    public Page<SellGoods> findAll(Pageable pageable) {
        return sellGoodsRepo.findAll(pageable);
    }

    @Override
    public SellGoods findOne(SellGoods sellGoods) {
        return sellGoodsRepo.findOne(Example.of(sellGoods, commontService.selectLikeName()))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND.getMessage()));
    }
}
