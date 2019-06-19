package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.model.BuyGoods;
import com.fudo.store.service.BuyGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyGoodsController {
    @Autowired
    private BuyGoodsService buyGoodsService;

    @PostMapping
    public Object save(@RequestBody BuyGoods buyGoods) {
        return buyGoodsService.save(buyGoods);
    }

    @PostMapping("/batch")
    public Object saveBatch(@RequestBody List<BuyGoods> list) {
        return buyGoodsService.saveBatch(list);
    }

    @GetMapping("/page")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return buyGoodsService.findAll(pageable.getPageable());
    }

    @GetMapping
    public Object findOne(@RequestBody BuyGoods buyGoods) {
        return buyGoodsService.findOne(buyGoods);
    }

}
