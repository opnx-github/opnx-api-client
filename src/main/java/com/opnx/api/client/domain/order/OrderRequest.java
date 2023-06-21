package com.opnx.api.client.domain.order;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
    private boolean requested;
    private String tag;
    private Long clientOrderId;
    private Long orderId;
    private String side;
    private BigDecimal quantity;
    private BigDecimal price;
    private String marketCode;
    private String orderType;
    private String timeInForce;
    private BigDecimal triggerPrice;
    @Deprecated
    private BigDecimal limitPrice;
    private BigDecimal stopPrice;
    private Integer source;
    private String triggerType;
    private BigDecimal amount;

    public boolean isRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(Long clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public BigDecimal getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("requested", requested)
                .append("tag", tag)
                .append("clientOrderId", clientOrderId)
                .append("orderId", orderId)
                .append("side", side)
                .append("quantity", quantity)
                .append("price", price)
                .append("marketCode", marketCode)
                .append("orderType", orderType)
                .append("timeInForce", timeInForce)
                .append("triggerPrice", triggerPrice)
                .append("limitPrice", limitPrice)
                .append("stopPrice", stopPrice)
                .append("source", source)
                .append("triggerType", triggerType)
                .append("amount", amount)
                .toString();
    }
}
