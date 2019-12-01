package com.ericwyles.chaosengineeringdemo.alphavantage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlphaVantageService {
    private final AlphaVantageClient alphaVantageClient;
    private final String alphavantageApiKey;

    public AlphaVantageService(AlphaVantageClient alphaVantageClient,
                               @Value("${alphavantage.api.key}") String alphavantageApiKey) {
        this.alphaVantageClient = alphaVantageClient;
        this.alphavantageApiKey = alphavantageApiKey;
    }

    public Double getPrice(String symbol) {
        log.info("Getting stock price for symbol {} from AlphaVantage...", symbol);
        GlobalQuoteResponse globalQuoteResponse = alphaVantageClient.getGlobalQuote(symbol, alphavantageApiKey);
        log.info("Response was {}", globalQuoteResponse);
        return Double.valueOf(globalQuoteResponse.getGlobalQuote().getPrice());
    }
}
