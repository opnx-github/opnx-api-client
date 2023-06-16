package com.opnx.api.client.domain.trade;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradesV3Resp {
    private String orderId;
    private String clientOrderId;
    private String matchId;
    private String marketCode;
    private String side;
    private String matchedQuantity;
    private String matchPrice;
    private String total;
    private String leg1Price;
    private String leg2Price;
    private String orderMatchType;
    private String feeAsset;
    private String fee;
    private String source;
    private String matchedAt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getMatchedQuantity() {
        return matchedQuantity;
    }

    public void setMatchedQuantity(String matchedQuantity) {
        this.matchedQuantity = matchedQuantity;
    }

    public String getMatchPrice() {
        return matchPrice;
    }

    public void setMatchPrice(String matchPrice) {
        this.matchPrice = matchPrice;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLeg1Price() {
        return leg1Price;
    }

    public void setLeg1Price(String leg1Price) {
        this.leg1Price = leg1Price;
    }

    public String getLeg2Price() {
        return leg2Price;
    }

    public void setLeg2Price(String leg2Price) {
        this.leg2Price = leg2Price;
    }

    public String getOrderMatchType() {
        return orderMatchType;
    }

    public void setOrderMatchType(String orderMatchType) {
        this.orderMatchType = orderMatchType;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .append("matchId", matchId)
                .append("marketCode", marketCode)
                .append("side", side)
                .append("matchedQuantity", matchedQuantity)
                .append("matchPrice", matchPrice)
                .append("total", total)
                .append("leg1Price", leg1Price)
                .append("leg2Price", leg2Price)
                .append("orderMatchType", orderMatchType)
                .append("feeAsset", feeAsset)
                .append("fee", fee)
                .append("source", source)
                .append("matchedAt", matchedAt)
                .toString();
    }
}
