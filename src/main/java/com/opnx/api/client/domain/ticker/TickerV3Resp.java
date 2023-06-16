package com.opnx.api.client.domain.ticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerV3Resp {
    private String marketCode;
    private String markPrice;
    private String open24h;
    private String high24h;
    private String low24h;
    private String volume24h;
    private String currencyVolume24h;
    private String openInterest;
    private String lastTradedPrice;
    private String lastTradedQuantity;
    private String lastUpdatedAt;


    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getOpen24h() {
        return open24h;
    }

    public void setOpen24h(String open24h) {
        this.open24h = open24h;
    }

    public String getHigh24h() {
        return high24h;
    }

    public void setHigh24h(String high24h) {
        this.high24h = high24h;
    }

    public String getLow24h() {
        return low24h;
    }

    public void setLow24h(String low24h) {
        this.low24h = low24h;
    }

    public String getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(String volume24h) {
        this.volume24h = volume24h;
    }

    public String getCurrencyVolume24h() {
        return currencyVolume24h;
    }

    public void setCurrencyVolume24h(String currencyVolume24h) {
        this.currencyVolume24h = currencyVolume24h;
    }

    public String getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(String openInterest) {
        this.openInterest = openInterest;
    }

    public String getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(String lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public String getLastTradedQuantity() {
        return lastTradedQuantity;
    }

    public void setLastTradedQuantity(String lastTradedQuantity) {
        this.lastTradedQuantity = lastTradedQuantity;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("markPrice", markPrice)
                .append("open24h", open24h)
                .append("high24h", high24h)
                .append("low24h", low24h)
                .append("volume24h", volume24h)
                .append("currencyVolume24h", currencyVolume24h)
                .append("openInterest", openInterest)
                .append("lastTradedPrice", lastTradedPrice)
                .append("lastTradedQuantity", lastTradedQuantity)
                .append("lastUpdatedAt", lastUpdatedAt)
                .toString();
    }
}
