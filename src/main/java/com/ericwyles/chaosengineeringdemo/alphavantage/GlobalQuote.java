package com.ericwyles.chaosengineeringdemo.alphavantage;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "01. symbol",
        "02. open",
        "03. high",
        "04. low",
        "05. price",
        "06. volume",
        "07. latest trading day",
        "08. previous close",
        "09. change",
        "10. change percent"
})
public class GlobalQuote {

    @JsonProperty("01. symbol") private String Symbol;
    @JsonProperty("02. open") private String Open;
    @JsonProperty("03. high") private String High;
    @JsonProperty("04. low") private String Low;
    @JsonProperty("05. price") private String Price;
    @JsonProperty("06. volume") private String Volume;
    @JsonProperty("07. latest trading day") private String LatestTradingDay;
    @JsonProperty("08. previous close") private String PreviousClose;
    @JsonProperty("09. change") private String Change;
    @JsonProperty("10. change percent") private String ChangePercent;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("01. symbol")
    public String getSymbol() {
        return Symbol;
    }

    @JsonProperty("01. symbol")
    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    @JsonProperty("02. open")
    public String getOpen() {
        return Open;
    }

    @JsonProperty("02. open")
    public void setOpen(String Open) {
        this.Open = Open;
    }

    @JsonProperty("03. high")
    public String getHigh() {
        return High;
    }

    @JsonProperty("03. high")
    public void setHigh(String High) {
        this.High = High;
    }

    @JsonProperty("04. low")
    public String getLow() {
        return Low;
    }

    @JsonProperty("04. low")
    public void setLow(String Low) {
        this.Low = Low;
    }

    @JsonProperty("05. price")
    public String getPrice() {
        return Price;
    }

    @JsonProperty("05. price")
    public void setPrice(String Price) {
        this.Price = Price;
    }

    @JsonProperty("06. volume")
    public String getVolume() {
        return Volume;
    }

    @JsonProperty("06. volume")
    public void setVolume(String Volume) {
        this.Volume = Volume;
    }

    @JsonProperty("07. latest trading day")
    public String getLatestTradingDay() {
        return LatestTradingDay;
    }

    @JsonProperty("07. latest trading day")
    public void setLatestTradingDay(String LatestTradingDay) {
        this.LatestTradingDay = LatestTradingDay;
    }

    @JsonProperty("08. previous close")
    public String getPreviousClose() {
        return PreviousClose;
    }

    @JsonProperty("08. previous close")
    public void setPreviousClose(String PreviousClose) {
        this.PreviousClose = PreviousClose;
    }

    @JsonProperty("09. change")
    public String getChange() {
        return Change;
    }

    @JsonProperty("09. change")
    public void setChange(String Change) {
        this.Change = Change;
    }

    @JsonProperty("10. change percent")
    public String getChangePercent() {
        return ChangePercent;
    }

    @JsonProperty("10. change percent")
    public void setChangePercent(String ChangePercent) {
        this.ChangePercent = ChangePercent;
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