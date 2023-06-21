package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerData{

    @JsonProperty("last")
    private String	last;
    @JsonProperty("open24h")
    private String	open24h;
    @JsonProperty("high24h")
    private String	high24h;
    @JsonProperty("low24h")
    private String	low24h;
    @JsonProperty("volume24h")
    private String	volume24h;
    @JsonProperty("currencyVolume24h")
    private String	currencyVolume24h;
    @JsonProperty("openInterest")
    private String	openInterest;
    @JsonProperty("marketCode")
    private String	marketCode;
    @JsonProperty("timestamp")
    private String	timestamp;
    @JsonProperty("lastQty")
    private String	lastQty;
    @JsonProperty("markPrice")
    private String	markPrice;
    @JsonProperty("lastMarkPrice")
    private String	lastMarkPrice;
    @JsonProperty("indexPrice")
    private String	indexPrice;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("last", last)
                       .append("open24h", open24h)
                       .append("high24h", high24h)
                       .append("low24h", low24h)
                       .append("volume24h", volume24h)
                       .append("currencyVolume24h", currencyVolume24h)
                       .append("openInterest", openInterest)
                       .append("marketCode", marketCode)
                       .append("timestamp", timestamp)
                       .append("lastQty", lastQty)
                       .append("markPrice", markPrice)
                       .append("lastMarkPrice", lastMarkPrice)
                       .append("indexPrice", indexPrice)
                       .toString();
    }

    public String getLast() {
      return this.last;
    }

    public void setLast(String last) {
      this.last = last;
    }

    public String getOpen24h() {
      return this.open24h;
    }

    public void setOpen24h(String open24h) {
      this.open24h = open24h;
    }

    public String getHigh24h() {
      return this.high24h;
    }

    public void setHigh24h(String high24h) {
      this.high24h = high24h;
    }

    public String getLow24h() {
      return this.low24h;
    }

    public void setLow24h(String low24h) {
      this.low24h = low24h;
    }

    public String getVolume24h() {
      return this.volume24h;
    }

    public void setVolume24h(String volume24h) {
      this.volume24h = volume24h;
    }

    public String getCurrencyVolume24h() {
      return this.currencyVolume24h;
    }

    public void setCurrencyVolume24h(String currencyVolume24h) {
      this.currencyVolume24h = currencyVolume24h;
    }

    public String getOpenInterest() {
      return this.openInterest;
    }

    public void setOpenInterest(String openInterest) {
      this.openInterest = openInterest;
    }

    public String getMarketCode() {
      return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
      this.marketCode = marketCode;
    }

    public String getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }

    public String getLastQty() {
      return this.lastQty;
    }

    public void setLastQty(String lastQty) {
      this.lastQty = lastQty;
    }

    public String getMarkPrice() {
      return this.markPrice;
    }

    public void setMarkPrice(String markPrice) {
      this.markPrice = markPrice;
    }

    public String getLastMarkPrice() {
      return this.lastMarkPrice;
    }

    public void setLastMarkPrice(String lastMarkPrice) {
      this.lastMarkPrice = lastMarkPrice;
    }

    public String getIndexPrice() {
      return this.indexPrice;
    }

    public void setIndexPrice(String indexPrice) {
      this.indexPrice = indexPrice;
    }

}
