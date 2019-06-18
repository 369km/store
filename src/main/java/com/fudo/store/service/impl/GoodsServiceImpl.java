package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.Goods;
import com.fudo.store.repository.GoodsRepo;
import com.fudo.store.service.GoodsService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepo goodsRepo;

    @Override
    public Goods save(Goods goods) {
        return goodsRepo.save(goods);
    }

    @Override
    public List<Goods> saveBatch(List<Goods> list) {
        return goodsRepo.saveAll(list);
    }

    @Override
    public Page<Goods> listAll(Pageable pageable) {
        return goodsRepo.findAll(pageable);
    }

    @Override
    public Goods findOne(Example<Goods> goods) {
        return goodsRepo.findOne(goods).orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND.getMessage()));
    }
}
