package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.model.Goods;
import com.fudo.store.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public Object saveBatch(@RequestBody List<Goods> goods) {
        return goodsService.saveBatch(goods);
    }

    @GetMapping("/all")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return goodsService.listAll(pageable.getPageable());
    }

    @GetMapping
    public Object findOne(@RequestBody Goods goods) {
        return goodsService.findOne(
                Example.of(goods, ExampleMatcher.matching()
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                        .withIgnorePaths("createTime")));
    }
}
