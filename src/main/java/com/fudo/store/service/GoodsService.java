package com.fudo.store.service;

import com.fudo.store.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsService {
    Goods save(Goods goods);

    List<Goods> saveBatch(List<Goods> list);

    Page<Goods> findAll(Pageable pageable);

    Goods findOne(Goods goods);
}
