package com.opnx.api.client.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Timestamp;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderHistoryV3Resp {
    private String orderId;
    private String clientOrderId;
    private String marketCode;
    private String status;
    private String side;
    private String price;
    private String stopPrice;
    private Boolean isTriggered;
    private String remainQuantity;
    private String totalQuantity;
    private String displayQuantity;
    private String amount;
    private String cumulativeMatchedQuantity;
    private String avgFillPrice;
    private String avgLeg1Price;
    private String avgLeg2Price;
    private Map<String, String> fees;
    private String orderType;
    private String triggerType;
    private String timeInForce;
    private String source;
    private String createdAt;
    private String lastModifiedAt;
    private String lastMatchedAt;
    private String canceledAt;
    private Timestamp transTime;

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

    public String getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(String remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getDisplayQuantity() {
        return displayQuantity;
    }

    public void setDisplayQuantity(String displayQuantity) {
        this.displayQuantity = displayQuantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCumulativeMatchedQuantity() {
        return cumulativeMatchedQuantity;
    }

    public void setCumulativeMatchedQuantity(String cumulativeMatchedQuantity) {
        this.cumulativeMatchedQuantity = cumulativeMatchedQuantity;
    }

    public String getAvgFillPrice() {
        return avgFillPrice;
    }

    public void setAvgFillPrice(String avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
    }

    public String getAvgLeg1Price() {
        return avgLeg1Price;
    }

    public void setAvgLeg1Price(String avgLeg1Price) {
        this.avgLeg1Price = avgLeg1Price;
    }

    public String getAvgLeg2Price() {
        return avgLeg2Price;
    }

    public void setAvgLeg2Price(String avgLeg2Price) {
        this.avgLeg2Price = avgLeg2Price;
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

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
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

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Timestamp getTransTime() {
        return transTime;
    }

    public void setTransTime(Timestamp transTime) {
        this.transTime = transTime;
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
                .append("remainQuantity", remainQuantity)
                .append("totalQuantity", totalQuantity)
                .append("displayQuantity", displayQuantity)
                .append("amount", amount)
                .append("cumulativeMatchedQuantity", cumulativeMatchedQuantity)
                .append("avgFillPrice", avgFillPrice)
                .append("avgLeg1Price", avgLeg1Price)
                .append("avgLeg2Price", avgLeg2Price)
                .append("fees", fees)
                .append("orderType", orderType)
                .append("triggerType", triggerType)
                .append("timeInForce", timeInForce)
                .append("source", source)
                .append("createdAt", createdAt)
                .append("lastModifiedAt", lastModifiedAt)
                .append("lastMatchedAt", lastMatchedAt)
                .append("canceledAt", canceledAt)
                .append("transTime", transTime)
                .toString();
    }
}
