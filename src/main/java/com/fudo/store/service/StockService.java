package com.fudo.store.service;

import com.fudo.store.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockService {
    Page<Stock> findAll(Pageable pageable);
}
