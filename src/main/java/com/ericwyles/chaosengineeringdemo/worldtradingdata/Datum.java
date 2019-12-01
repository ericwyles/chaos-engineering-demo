package com.ericwyles.chaosengineeringdemo.worldtradingdata;

import java.util.HashMap;
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
        "symbol",
        "name",
        "price",
        "currency",
        "price_open",
        "day_high",
        "day_low",
        "52_week_high",
        "52_week_low",
        "day_change",
        "change_pct",
        "close_yesterday",
        "market_cap",
        "volume",
        "volume_avg",
        "shares",
        "stock_exchange_long",
        "stock_exchange_short",
        "timezone",
        "timezone_name",
        "gmt_offset",
        "last_trade_time",
        "pe",
        "eps"
})
@ToString
public class Datum {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("price_open")
    private String priceOpen;
    @JsonProperty("day_high")
    private String dayHigh;
    @JsonProperty("day_low")
    private String dayLow;
    @JsonProperty("52_week_high")
    private String _52WeekHigh;
    @JsonProperty("52_week_low")
    private String _52WeekLow;
    @JsonProperty("day_change")
    private String dayChange;
    @JsonProperty("change_pct")
    private String changePct;
    @JsonProperty("close_yesterday")
    private String closeYesterday;
    @JsonProperty("market_cap")
    private String marketCap;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("volume_avg")
    private String volumeAvg;
    @JsonProperty("shares")
    private String shares;
    @JsonProperty("stock_exchange_long")
    private String stockExchangeLong;
    @JsonProperty("stock_exchange_short")
    private String stockExchangeShort;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_name")
    private String timezoneName;
    @JsonProperty("gmt_offset")
    private String gmtOffset;
    @JsonProperty("last_trade_time")
    private String lastTradeTime;
    @JsonProperty("pe")
    private String pe;
    @JsonProperty("eps")
    private String eps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("price_open")
    public String getPriceOpen() {
        return priceOpen;
    }

    @JsonProperty("price_open")
    public void setPriceOpen(String priceOpen) {
        this.priceOpen = priceOpen;
    }

    @JsonProperty("day_high")
    public String getDayHigh() {
        return dayHigh;
    }

    @JsonProperty("day_high")
    public void setDayHigh(String dayHigh) {
        this.dayHigh = dayHigh;
    }

    @JsonProperty("day_low")
    public String getDayLow() {
        return dayLow;
    }

    @JsonProperty("day_low")
    public void setDayLow(String dayLow) {
        this.dayLow = dayLow;
    }

    @JsonProperty("52_week_high")
    public String get52WeekHigh() {
        return _52WeekHigh;
    }

    @JsonProperty("52_week_high")
    public void set52WeekHigh(String _52WeekHigh) {
        this._52WeekHigh = _52WeekHigh;
    }

    @JsonProperty("52_week_low")
    public String get52WeekLow() {
        return _52WeekLow;
    }

    @JsonProperty("52_week_low")
    public void set52WeekLow(String _52WeekLow) {
        this._52WeekLow = _52WeekLow;
    }

    @JsonProperty("day_change")
    public String getDayChange() {
        return dayChange;
    }

    @JsonProperty("day_change")
    public void setDayChange(String dayChange) {
        this.dayChange = dayChange;
    }

    @JsonProperty("change_pct")
    public String getChangePct() {
        return changePct;
    }

    @JsonProperty("change_pct")
    public void setChangePct(String changePct) {
        this.changePct = changePct;
    }

    @JsonProperty("close_yesterday")
    public String getCloseYesterday() {
        return closeYesterday;
    }

    @JsonProperty("close_yesterday")
    public void setCloseYesterday(String closeYesterday) {
        this.closeYesterday = closeYesterday;
    }

    @JsonProperty("market_cap")
    public String getMarketCap() {
        return marketCap;
    }

    @JsonProperty("market_cap")
    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonProperty("volume_avg")
    public String getVolumeAvg() {
        return volumeAvg;
    }

    @JsonProperty("volume_avg")
    public void setVolumeAvg(String volumeAvg) {
        this.volumeAvg = volumeAvg;
    }

    @JsonProperty("shares")
    public String getShares() {
        return shares;
    }

    @JsonProperty("shares")
    public void setShares(String shares) {
        this.shares = shares;
    }

    @JsonProperty("stock_exchange_long")
    public String getStockExchangeLong() {
        return stockExchangeLong;
    }

    @JsonProperty("stock_exchange_long")
    public void setStockExchangeLong(String stockExchangeLong) {
        this.stockExchangeLong = stockExchangeLong;
    }

    @JsonProperty("stock_exchange_short")
    public String getStockExchangeShort() {
        return stockExchangeShort;
    }

    @JsonProperty("stock_exchange_short")
    public void setStockExchangeShort(String stockExchangeShort) {
        this.stockExchangeShort = stockExchangeShort;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("timezone_name")
    public String getTimezoneName() {
        return timezoneName;
    }

    @JsonProperty("timezone_name")
    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    @JsonProperty("gmt_offset")
    public String getGmtOffset() {
        return gmtOffset;
    }

    @JsonProperty("gmt_offset")
    public void setGmtOffset(String gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    @JsonProperty("last_trade_time")
    public String getLastTradeTime() {
        return lastTradeTime;
    }

    @JsonProperty("last_trade_time")
    public void setLastTradeTime(String lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    @JsonProperty("pe")
    public String getPe() {
        return pe;
    }

    @JsonProperty("pe")
    public void setPe(String pe) {
        this.pe = pe;
    }

    @JsonProperty("eps")
    public String getEps() {
        return eps;
    }

    @JsonProperty("eps")
    public void setEps(String eps) {
        this.eps = eps;
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