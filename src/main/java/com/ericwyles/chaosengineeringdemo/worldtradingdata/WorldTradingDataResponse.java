package com.ericwyles.chaosengineeringdemo.worldtradingdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbols_requested",
        "symbols_returned",
        "data"
})
@ToString
public class WorldTradingDataResponse {

    @JsonProperty("symbols_requested")
    private Integer symbolsRequested;
    @JsonProperty("symbols_returned")
    private Integer symbolsReturned;
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("symbols_requested")
    public Integer getSymbolsRequested() {
        return symbolsRequested;
    }

    @JsonProperty("symbols_requested")
    public void setSymbolsRequested(Integer symbolsRequested) {
        this.symbolsRequested = symbolsRequested;
    }

    @JsonProperty("symbols_returned")
    public Integer getSymbolsReturned() {
        return symbolsReturned;
    }

    @JsonProperty("symbols_returned")
    public void setSymbolsReturned(Integer symbolsReturned) {
        this.symbolsReturned = symbolsReturned;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}