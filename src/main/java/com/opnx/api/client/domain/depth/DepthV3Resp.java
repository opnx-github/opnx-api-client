package com.opnx.api.client.domain.depth;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthV3Resp {
    private String marketCode;
    private String lastUpdatedAt;
    private List asks;
    private List bids;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public List getAsks() {
        return asks;
    }

    public void setAsks(JSONArray asks) {
        this.asks = asks;
    }

    public List getBids() {
        return bids;
    }

    public void setBids(JSONArray bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("lastUpdatedAt", lastUpdatedAt)
                .append("asks", asks)
                .append("bids", bids)
                .toString();
    }
}
