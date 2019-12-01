package com.ericwyles.chaosengineeringdemo.worldtradingdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorldTradingDataService {
    private final WorldTradingDataClient worldTradingDataClient;
    private final String worldtradingdataApiKey;

    public WorldTradingDataService(WorldTradingDataClient worldTradingDataClient,
                                   @Value("${worldtradingdata.api.key}") String worldtradingdataApiKey) {
        this.worldTradingDataClient = worldTradingDataClient;
        this.worldtradingdataApiKey = worldtradingdataApiKey;
    }

    public Double getPrice(String symbol) {
        log.info("Getting stock price for symbol {} from WorldTradingData...", symbol);
        WorldTradingDataResponse worldTradingDataResponse = worldTradingDataClient.getRealTimeMarketData(symbol, worldtradingdataApiKey);
        log.info("Response was {}", worldTradingDataResponse);
        return Double.valueOf(worldTradingDataResponse.getData().get(0).getPrice());
    }
}
