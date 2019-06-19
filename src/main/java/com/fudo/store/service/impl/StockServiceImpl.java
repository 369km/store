package com.fudo.store.service.impl;

import com.fudo.store.model.Stock;
import com.fudo.store.repository.StockRepo;
import com.fudo.store.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepo stockRepo;

    @Override
    public Page<Stock> findAll(Pageable pageable) {
        return stockRepo.findAll(pageable);
    }
}
