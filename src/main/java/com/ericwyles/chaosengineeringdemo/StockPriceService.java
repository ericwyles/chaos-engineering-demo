package com.ericwyles.chaosengineeringdemo;

import com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageClient;
import com.ericwyles.chaosengineeringdemo.alphavantage.GlobalQuoteResponse;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataClient;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockPriceService {

    private final AlphaVantageClient alphaVantageClient;
    private final String alphavantageApiKey;

    private final WorldTradingDataClient worldTradingDataClient;
    private final String worldtradingdataApiKey;

    public StockPriceService(AlphaVantageClient alphaVantageClient,
                             @Value("${alphavantage.api.key}") String alphavantageApiKey,
                             WorldTradingDataClient worldTradingDataClient,
                             @Value("${worldtradingdata.api.key}") String worldtradingdataApiKey) {
        this.alphaVantageClient = alphaVantageClient;
        this.alphavantageApiKey = alphavantageApiKey;

        this.worldTradingDataClient = worldTradingDataClient;
        this.worldtradingdataApiKey = worldtradingdataApiKey;
    }

    @CircuitBreaker(name = "stockPriceCircuitBreaker", fallbackMethod = "getPriceFallback")
    public Double getPrice(String symbol) {
        log.info("Getting stock price for symbol {} from AlphaVantage...", symbol);
        GlobalQuoteResponse globalQuoteResponse = alphaVantageClient.getGlobalQuote(symbol, alphavantageApiKey);
        return Double.valueOf(globalQuoteResponse.getGlobalQuote().getPrice());
    }


    public Double getPriceFallback(String symbol, Throwable throwable) {
        log.info("Getting stock price for symbol {} from WorldTradingData...", symbol);
        WorldTradingDataResponse worldTradingDataResponse = worldTradingDataClient.getRealTimeMarketData(symbol, worldtradingdataApiKey);
        return Double.valueOf(worldTradingDataResponse.getData().get(0).getPrice());
    }
}
