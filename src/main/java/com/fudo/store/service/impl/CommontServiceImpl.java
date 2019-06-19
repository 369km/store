package com.fudo.store.service.impl;

import com.fudo.store.dto.GoodsInfo;
import com.fudo.store.exception.BaseException;
import com.fudo.store.model.Goods;
import com.fudo.store.model.Stock;
import com.fudo.store.repository.GoodsRepo;
import com.fudo.store.repository.StockRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.type.BaseEnum;
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
        Stock stockFromDb = stockRepo.findByGoodsId(goodsInfo.getGoodsId());
        Stock stock = new Stock();
        if (Objects.nonNull(stockFromDb)) {
            BeanUtils.copyProperties(stockFromDb, stock);
        } else {
            stock.setGoodsId(goodsInfo.getGoodsId());
        }
        stock.setTotal(nullToLong(stock.getTotal()) + goodsInfo.getAmount());
        stock.setRemains(stock.getTotal() - nullToLong(stock.getSells()));
        Optional<Goods> goodsFromDb = goodsRepo.findById(goodsInfo.getGoodsId());
        stock.setCost(nullToDecimal(stock.getCost()).add(goodsFromDb.get().getBuyPrice().multiply(BigDecimal.valueOf(goodsInfo.getAmount()))));
        return stockRepo.save(stock);
    }

    @Override
    public Stock sellStock(GoodsInfo goodsInfo) {
        Stock stock = stockRepo.findByGoodsId(goodsInfo.getGoodsId());
        stock.setSells(nullToLong(stock.getSells()) + goodsInfo.getAmount());
        stock.setRemains(stock.getTotal() - stock.getSells());
        if (stock.getRemains() < 0) {
            throw new BaseException(BaseEnum.INSUFFICIENT_STOCK.getMessage());
        }
        Optional<Goods> goodsFromDb = goodsRepo.findById(goodsInfo.getGoodsId());
        stock.setProfit(nullToDecimal(stock.getProfit()).add(goodsFromDb.get().getSellPrice().subtract(goodsFromDb.get().getBuyPrice()).multiply(BigDecimal.valueOf(goodsInfo.getAmount()))));
        return stockRepo.save(stock);
    }

    private Long nullToLong(Long l) {
        return Objects.isNull(l) ? 0L : l;
    }

    private BigDecimal nullToDecimal(BigDecimal b) {
        return Objects.isNull(b) ? BigDecimal.ZERO : b;
    }

}
