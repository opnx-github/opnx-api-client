package com.opnx.api.client.domain.order;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkingOrderV3Resp {
    private String orderId;
    private String clientOrderId;
    private String marketCode;
    private String status;
    private String side;
    private String price;
    private String stopPrice;
    private Boolean isTriggered;
    private String quantity;
    private String remainQuantity;
    private String matchedQuantity;
    private String avgFillPrice;
    private String triggerType;
    private String amount;
    private String displayQuantity;
    private Map<String, String> fees;
    private String orderType;
    private String timeInForce;
    private String source;
    private String createdAt;
    private String lastModifiedAt;
    private String lastMatchedAt;

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

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Boolean getTriggered() {
        return isTriggered;
    }

    public void setTriggered(Boolean triggered) {
        isTriggered = triggered;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(String remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public String getMatchedQuantity() {
        return matchedQuantity;
    }

    public void setMatchedQuantity(String matchedQuantity) {
        this.matchedQuantity = matchedQuantity;
    }

    public String getAvgFillPrice() {
        return avgFillPrice;
    }

    public void setAvgFillPrice(String avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDisplayQuantity() {
        return displayQuantity;
    }

    public void setDisplayQuantity(String displayQuantity) {
        this.displayQuantity = displayQuantity;
    }

    public Map<String, String> getFees() {
        return fees;
    }

    public void setFees(Map<String, String> fees) {
        this.fees = fees;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getLastMatchedAt() {
        return lastMatchedAt;
    }

    public void setLastMatchedAt(String lastMatchedAt) {
        this.lastMatchedAt = lastMatchedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderId", orderId)
                .append("clientOrderId", clientOrderId)
                .append("marketCode", marketCode)
                .append("status", status)
                .append("side", side)
                .append("price", price)
                .append("stopPrice", stopPrice)
                .append("isTriggered", isTriggered)
                .append("quantity", quantity)
                .append("remainQuantity", remainQuantity)
                .append("matchedQuantity", matchedQuantity)
                .append("avgFillPrice", avgFillPrice)
                .append("triggerType", triggerType)
                .append("amount", amount)
                .append("displayQuantity", displayQuantity)
                .append("fees", fees)
                .append("orderType", orderType)
                .append("timeInForce", timeInForce)
                .append("source", source)
                .append("createdAt", createdAt)
                .append("lastModifiedAt", lastModifiedAt)
                .append("lastMatchedAt", lastMatchedAt)
                .toString();
    }
}
