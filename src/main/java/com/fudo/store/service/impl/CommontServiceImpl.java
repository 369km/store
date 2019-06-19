package com.fudo.store.service.impl;

import com.fudo.store.dto.GoodsInfo;
import com.fudo.store.model.BaseModel;
import com.fudo.store.model.Goods;
import com.fudo.store.model.Stock;
import com.fudo.store.repository.GoodsRepo;
import com.fudo.store.repository.StockRepo;
import com.fudo.store.service.CommontService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommontServiceImpl implements CommontService {
    @Autowired
    private StockRepo stockRepo;
    @Autowired
    private GoodsRepo goodsRepo;

    @Override
    public ExampleMatcher selectLikeName() {
        return ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("createTime");
    }

    @Override
    public Stock buyStock(GoodsInfo goodsInfo) {
        Stock stock = buildStock(goodsInfo);
        stock.setRemains(stock.getTotal() - stock.getSells());
        Optional<Goods> goodsFromDb = goodsRepo.findById(goodsInfo.getGoodsId());
        stock.setCost(stock.getCost().add(goodsFromDb.get().getBuyPrice().multiply(BigDecimal.valueOf(goodsInfo.getAmount()))));
        return stockRepo.save(stock);
    }

    @Override
    public Stock sellStock(GoodsInfo goodsInfo) {
        Stock stock = buildStock(goodsInfo);
        stock.setSells(stock.getSells() + goodsInfo.getAmount());
        stock.setRemains(stock.getTotal() - stock.getSells());
        Optional<Goods> goodsFromDb = goodsRepo.findById(goodsInfo.getGoodsId());
        stock.setProfit(stock.getProfit().add(goodsFromDb.get().getSellPrice().multiply(BigDecimal.valueOf(goodsInfo.getAmount()))));
        return stockRepo.save(stock);
    }

    private Stock buildStock(GoodsInfo goodsInfo) {
        Stock stockFromDb = stockRepo.findByGoodsId(goodsInfo.getGoodsId());
        Stock stock = new Stock();
        if (Objects.nonNull(stockFromDb)) {
            BeanUtils.copyProperties(stockFromDb, stock);
        } else {
            stock.setGoodsId(goodsInfo.getGoodsId());
        }
        stock.setTotal(stock.getTotal() + goodsInfo.getAmount());
        return stock;
    }

}
