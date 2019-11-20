package com.fudo.store.controller;

import com.fudo.store.dto.PageableImpl;
import com.fudo.store.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/page")
    public Object findAll(@RequestBody PageableImpl pageable) {
        return stockService.findAll(pageable.getPageable());
    }
}
