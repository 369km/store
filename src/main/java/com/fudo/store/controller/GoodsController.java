package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.model.Goods;
import com.fudo.store.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public Object save(@RequestBody Goods goods) {
        return goodsService.save(goods);
    }

    @PostMapping("/batch")
    public Object saveBatch(@RequestBody List<Goods> list) {
        return goodsService.saveBatch(list);
    }

    @GetMapping("/all")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return goodsService.findAll(pageable.getPageable());
    }

    @GetMapping
    public Object findOne(@RequestBody Goods goods) {
        return goodsService.findOne(goods);
    }
}
