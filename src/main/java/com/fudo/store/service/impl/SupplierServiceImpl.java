package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.Supplier;
import com.fudo.store.repository.SupplierRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.service.SupplierService;
import com.fudo.store.type.BaseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private CommontService commontService;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> saveBatch(List<Supplier> list) {
        return supplierRepo.saveAll(list);
    }

    @Override
    public Page<Supplier> findAll(Pageable pageable) {
        return supplierRepo.findAll(pageable);
    }

    @Override
    public Supplier findOne(Supplier supplier) {
        return supplierRepo.findOne(Example.of(supplier, commontService.selectLikeName()))
                .orElseThrow(() -> new BaseException(BaseEnum.DATA_NOT_FOND));
    }
}
