package com.ericwyles.chaosengineeringdemo;

import com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageClient;
import com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageService;
import com.ericwyles.chaosengineeringdemo.alphavantage.GlobalQuoteResponse;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataClient;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataResponse;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockPriceService {
    private final AlphaVantageService alphaVantageService;
    private final WorldTradingDataService worldTradingDataService;

    public StockPriceService(AlphaVantageService alphaVantageService, WorldTradingDataService worldTradingDataService) {
        this.alphaVantageService = alphaVantageService;
        this.worldTradingDataService = worldTradingDataService;
    }

    @CircuitBreaker(name = "stockPriceCircuitBreaker", fallbackMethod = "getPriceFallback")
    public Double getPrice(String symbol) {
        return alphaVantageService.getPrice(symbol);
    }

    public Double getPriceFallback(String symbol, Throwable throwable) {
        if (throwable instanceof CallNotPermittedException) {
            log.info("{}", throwable.getMessage());
        }
        return worldTradingDataService.getPrice(symbol);
    }
}
