package com.fudo.store.service;

import com.fudo.store.model.Supplier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);

    List<Supplier> saveBatch(List<Supplier> list);

    Page<Supplier> findAll(Pageable pageable);

    Supplier findOne(Example<Supplier> supplier);
}
