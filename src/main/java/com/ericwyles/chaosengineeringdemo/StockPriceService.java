package com.ericwyles.chaosengineeringdemo;

import com.ericwyles.chaosengineeringdemo.alphavantage.AlphaVantageService;
import com.ericwyles.chaosengineeringdemo.worldtradingdata.WorldTradingDataService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class StockPriceService {
    private final AlphaVantageService alphaVantageService;
    private final WorldTradingDataService worldTradingDataService;
    private final Integer alphaVantageTimeout;

    public StockPriceService(AlphaVantageService alphaVantageService,
                             WorldTradingDataService worldTradingDataService,
                             @Value("${alphavantage.timeout}")  Integer alphaVantageTimeout) {
        this.alphaVantageService = alphaVantageService;
        this.worldTradingDataService = worldTradingDataService;
        this.alphaVantageTimeout = alphaVantageTimeout;
    }

    @CircuitBreaker(name = "stockPriceCircuitBreaker", fallbackMethod = "getPriceFallback")
    public Double getPrice(String symbol) throws InterruptedException, ExecutionException {

        log.info("Calling alphaVantageService with a timeout of {} seconds...", alphaVantageTimeout);
        // wrap in a completable future so we can time out the call after 3 seconds
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() ->
                alphaVantageService.getPrice(symbol)).orTimeout(alphaVantageTimeout, TimeUnit.SECONDS);

        return future.get();
    }

    public Double getPriceFallback(String symbol, Throwable throwable) {
        if (throwable instanceof CallNotPermittedException) {
            log.info("{}", throwable.getMessage());
        }
        return worldTradingDataService.getPrice(symbol);
    }
}
