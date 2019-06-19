package com.fudo.store.service.impl;

import com.fudo.store.exception.BaseException;
import com.fudo.store.model.BuyGoods;
import com.fudo.store.model.Goods;
import com.fudo.store.model.SellGoods;
import com.fudo.store.model.Stock;
import com.fudo.store.repository.GoodsRepo;
import com.fudo.store.repository.StockRepo;
import com.fudo.store.service.CommontService;
import com.fudo.store.type.BaseEnum;
import com.fudo.store.util.NumberUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Stock buyStock(BuyGoods buyGoods) {
        Stock stockFromDb = stockRepo.findByGoodsId(buyGoods.getGoodsId());
        return stockRepo.save(buildBuyStock(stockFromDb, buyGoods));
    }

    private Stock buildBuyStock(Stock stockFromDb, BuyGoods buyGoods) {
        Stock stock = new Stock();
        if (Objects.nonNull(stockFromDb)) {
            BeanUtils.copyProperties(stockFromDb, stock);
        } else {
            stock.setGoodsId(buyGoods.getGoodsId());
        }
        stock.setModifyTime(LocalDateTime.now());
        stock.setTotal(NumberUtil.nullToLong(stock.getTotal()) + buyGoods.getAmount());
        stock.setRemains(stock.getTotal() - NumberUtil.nullToLong(stock.getSells()));
        Optional<Goods> goodsFromDb = goodsRepo.findById(buyGoods.getGoodsId());
        stock.setCost(NumberUtil.nullToDecimal(stock.getCost()).add(goodsFromDb.get().getBuyPrice().multiply(BigDecimal.valueOf(buyGoods.getAmount()))));
        return stock;
    }

    @Override
    public List<Stock> buyStockBatch(List<BuyGoods> list) {
        List<Stock> stockListFromDb = stockRepo.findByGoodsIdIn(list.stream().map(BuyGoods::getGoodsId).collect(Collectors.toList()));
        List<Stock> stocks = new ArrayList<>(list.size());
        if (CollectionUtils.isEmpty(stockListFromDb)) {
            list.forEach(buyGoods -> stocks.add(buildBuyStock(null, buyGoods)));
        } else {
            for (Stock stock : stockListFromDb) {
                stocks.add(buildBuyStock(stock, list.stream().filter(buyGoods -> buyGoods.getGoodsId().equals(stock.getGoodsId())).findFirst().get()));
            }
            for (BuyGoods buyGoods : list.stream().filter(buyGoods -> stockListFromDb.stream().map(Stock::getGoodsId).noneMatch(goodsId -> buyGoods.getGoodsId().equals(goodsId))).collect(Collectors.toList())) {
                stocks.add(buildBuyStock(null, buyGoods));
            }
        }
        return stockRepo.saveAll(stocks);
    }

    @Override
    public Stock sellStock(SellGoods sellGoods) {
        Stock stock = stockRepo.findByGoodsId(sellGoods.getGoodsId());
        return stockRepo.save(buildSellStock(stock, sellGoods));
    }

    private Stock buildSellStock(Stock stock, SellGoods sellGoods) {
        stock.setModifyTime(LocalDateTime.now());
        stock.setSells(NumberUtil.nullToLong(stock.getSells()) + sellGoods.getAmount());
        stock.setRemains(stock.getTotal() - stock.getSells());
        if (stock.getRemains() < 0) {
            throw new BaseException(BaseEnum.INSUFFICIENT_STOCK.getMessage(), sellGoods);
        }
        Optional<Goods> goodsFromDb = goodsRepo.findById(sellGoods.getGoodsId());
        stock.setProfit(NumberUtil.nullToDecimal(stock.getProfit()).add(goodsFromDb.get().getSellPrice().subtract(goodsFromDb.get().getBuyPrice()).multiply(BigDecimal.valueOf(sellGoods.getAmount()))));
        return stock;
    }

    @Override
    public List<Stock> sellStockBatch(List<SellGoods> list) {
        List<Stock> stockListFromDb = stockRepo.findByGoodsIdIn(list.stream().map(SellGoods::getGoodsId).collect(Collectors.toList()));
        List<Stock> stocks = new ArrayList<>(list.size());
        if (!CollectionUtils.isEmpty(stockListFromDb)) {
            for (Stock stock : stockListFromDb) {
                stocks.add(buildSellStock(stock, list.stream().filter(sellGoods -> sellGoods.getGoodsId().equals(stock.getGoodsId())).findFirst().get()));
            }
        }
        return stockRepo.saveAll(stocks);
    }

}
