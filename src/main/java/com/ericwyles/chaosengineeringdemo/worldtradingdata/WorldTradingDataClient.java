package com.ericwyles.chaosengineeringdemo.worldtradingdata;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "worldtradingdata", url = "${worldtradingdata.url}")
public interface WorldTradingDataClient {
    @RequestMapping(method = RequestMethod.GET, value="/api/v1/stock?symbol={stockSymbol}&api_token={apiKey}", consumes = "application/json")
    WorldTradingDataResponse getRealTimeMarketData(@PathVariable("stockSymbol") String stockSymbol, @PathVariable("apiKey") String apiKey);
}
