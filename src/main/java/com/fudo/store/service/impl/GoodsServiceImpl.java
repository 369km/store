package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.Goods;
import com.fudo.store.repository.GoodsRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.service.GoodsService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepo goodsRepo;
    @Autowired
    private CommontService commontService;

    @Override
    public Goods save(Goods goods) {
        checkDuplicateEntry(goods);
        return goodsRepo.save(goods);
    }

    private void checkDuplicateEntry(Goods goods) {
        Goods db = goodsRepo.findByNameAndSpecs(goods.getName(), goods.getSpecs());
        if (Objects.nonNull(db)) {
            throw new BaseException(BaseEnum.DUPLICATE_ENTRY, db);
        }
    }

    @Override
    public List<Goods> saveBatch(List<Goods> list) {
        Set<Goods> set = new HashSet<>(list);
        set.forEach(this::checkDuplicateEntry);
        return goodsRepo.saveAll(list);
    }

    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepo.findAll(pageable);
    }

    @Override
    public Goods findOne(Goods goods) {
        return goodsRepo.findOne(Example.of(goods, commontService.selectLikeName()))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND));
    }
}
