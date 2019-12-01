package com.ericwyles.chaosengineeringdemo;

import com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class StockPriceService {
    private final AlphaVantageService alphaVantageService;

    public StockPriceService(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    public Double getPrice(String symbol) {
        return alphaVantageService.getPrice(symbol);
    }
}
