package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.model.SellGoods;
import com.fudo.store.service.SellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sell")
public class SellGoodsController {
    @Autowired
    private SellGoodsService sellGoodsService;

    @PostMapping
    public Object save(@RequestBody SellGoods sellGoods) {
        return sellGoodsService.save(sellGoods);
    }

    @PostMapping("/batch")
    public Object saveBatch(@RequestBody List<SellGoods> list) {
        return sellGoodsService.saveBatch(list);
    }

    @GetMapping("/page")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return sellGoodsService.findAll(pageable.getPageable());
    }

    @GetMapping
    public Object findOne(@RequestBody SellGoods sellGoods) {
        return sellGoodsService.findOne(sellGoods);
    }
}
