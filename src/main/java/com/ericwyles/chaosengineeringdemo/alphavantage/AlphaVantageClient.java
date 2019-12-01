package com.ericwyles.chaosengineeringdemo.alphavantage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "alphavantage", url = "${alphavantage.url}")
public interface AlphaVantageClient {
    @RequestMapping(method = RequestMethod.GET,
                    value="/query?function=GLOBAL_QUOTE&symbol={stockSymbol}&apikey={apiKey}",
                    consumes = "application/json")
    GlobalQuoteResponse getGlobalQuote(@PathVariable("stockSymbol") String stockSymbol, @PathVariable("apiKey") String apiKey);
}
