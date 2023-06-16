package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderData {

    @JsonProperty("accountId")
    private String	accountId;
    @JsonProperty("clientOrderId")
    private String	clientOrderId;
    @JsonProperty("orderId")
    private String	orderId;
    @JsonProperty("price")
    private String	price;
    @JsonProperty("quantity")
    private String	quantity;
    @JsonProperty("side")
    private String	side;
    @JsonProperty("status")
    private String	status;
    @JsonProperty("marketCode")
    private String	marketCode;
    @JsonProperty("timeInForce")
    private String	timeInForce;
    @JsonProperty("timestamp")
    private String	timestamp;
    @JsonProperty("remainQuantity")
    private String	remainQuantity;
    @JsonProperty("limitPrice")
    private String	limitPrice;
    @JsonProperty("stopPrice")
    private String	stopPrice;
    @JsonProperty("notice")
    private String	notice;
    @JsonProperty("orderType")
    private String	orderType;
    @JsonProperty("isTriggered")
    private String	isTriggered;
    @JsonProperty("source")
    private Integer	source;
    @JsonProperty("triggerType")
    private String	triggerType;

    @JsonProperty("amount")
    private String	amount;
    @JsonProperty("displayQuantity")
    private String	displayQuantity;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("accountId", accountId)
                       .append("clientOrderId", clientOrderId)
                       .append("orderId", orderId)
                       .append("price", price)
                       .append("quantity", quantity)
                       .append("side", side)
                       .append("status", status)
                       .append("marketCode", marketCode)
                       .append("timeInForce", timeInForce)
                       .append("timestamp", timestamp)
                       .append("remainQuantity", remainQuantity)
                       .append("limitPrice", limitPrice)
                       .append("notice", notice)
                       .append("orderType", orderType)
                       .append("isTriggered", isTriggered)
                       .append("amount", amount)
                       .append("displayQuantity", displayQuantity)
                       .toString();
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return this.side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getTimeInForce() {
        return this.timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRemainQuantity() {
        return this.remainQuantity;
    }

    public void setRemainQuantity(String remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public String getLimitPrice() {
        return this.limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getNotice() {
        return this.notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIsTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(String isTriggered) {
        this.isTriggered = isTriggered;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
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
}
