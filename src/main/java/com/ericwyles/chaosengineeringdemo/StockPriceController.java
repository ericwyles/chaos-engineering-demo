package com.ericwyles.chaosengineeringdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StockPriceController {

    StockPriceService stockPriceService;

    public StockPriceController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping("/stock-price/{tickerSymbol}")
    public Double getStockPrice(@PathVariable("tickerSymbol") String tickerSymbol) throws Exception {
        return stockPriceService.getPrice(tickerSymbol);
    }
}
