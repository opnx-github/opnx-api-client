package com.opnx.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketsV3Resp {
    private String marketCode;
    private String name;
    private String referencePair;
    private String base;
    private String counter;
    private String type;
    private String tickSize;
    private String minSize;
    private String listedAt;
    private String settlementAt;
    private String upperPriceBound;
    private String lowerPriceBound;
    private String markPrice;
    private String indexPrice;
    private String lastUpdatedAt;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferencePair() {
        return referencePair;
    }

    public void setReferencePair(String referencePair) {
        this.referencePair = referencePair;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTickSize() {
        return tickSize;
    }

    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    public String getMinSize() {
        return minSize;
    }

    public void setMinSize(String minSize) {
        this.minSize = minSize;
    }

    public String getListedAt() {
        return listedAt;
    }

    public void setListedAt(String listedAt) {
        this.listedAt = listedAt;
    }

    public String getSettlementAt() {
        return settlementAt;
    }

    public void setSettlementAt(String settlementAt) {
        this.settlementAt = settlementAt;
    }

    public String getUpperPriceBound() {
        return upperPriceBound;
    }

    public void setUpperPriceBound(String upperPriceBound) {
        this.upperPriceBound = upperPriceBound;
    }

    public String getLowerPriceBound() {
        return lowerPriceBound;
    }

    public void setLowerPriceBound(String lowerPriceBound) {
        this.lowerPriceBound = lowerPriceBound;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(String indexPrice) {
        this.indexPrice = indexPrice;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("name", name)
                .append("referencePair", referencePair)
                .append("base", base)
                .append("counter", counter)
                .append("type", type)
                .append("tickSize", tickSize)
                .append("minSize", minSize)
                .append("listedAt", listedAt)
                .append("settlementAt", settlementAt)
                .append("upperPriceBound", upperPriceBound)
                .append("lowerPriceBound", lowerPriceBound)
                .append("markPrice", markPrice)
                .append("indexPrice", indexPrice)
                .append("lastUpdatedAt", lastUpdatedAt)
                .toString();
    }
}
