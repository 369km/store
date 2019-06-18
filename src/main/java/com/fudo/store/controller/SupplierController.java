package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.model.Supplier;
import com.fudo.store.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public Object save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PostMapping("/batch")
    public Object saveBatch(@RequestBody List<Supplier> list) {
        return supplierService.saveBatch(list);
    }

    @GetMapping("/all")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return supplierService.findAll(pageable.getPageable());
    }

    @GetMapping
    public Object findOne(@RequestBody Supplier supplier) {
        return supplierService.findOne(supplier);
    }
}
