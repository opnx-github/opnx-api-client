package com.opnx.api.client.domain.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicTradesV3Resp {
    private String marketCode;
    private String matchPrice;
    private String matchQuantity;
    private String side;
    private String matchType;
    private String matchedAt;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMatchPrice() {
        return matchPrice;
    }

    public void setMatchPrice(String matchPrice) {
        this.matchPrice = matchPrice;
    }

    public String getMatchQuantity() {
        return matchQuantity;
    }

    public void setMatchQuantity(String matchQuantity) {
        this.matchQuantity = matchQuantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchedAt() {
        return matchedAt;
    }

    public void setMatchedAt(String matchedAt) {
        this.matchedAt = matchedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("matchPrice", matchPrice)
                .append("matchQuantity", matchQuantity)
                .append("side", side)
                .append("matchType", matchType)
                .append("matchedAt", matchedAt)
                .toString();
    }
}
