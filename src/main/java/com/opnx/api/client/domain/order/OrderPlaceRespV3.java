package com.opnx.api.client.domain.order;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlaceRespV3 {
    private String notice;
    private String code;
    private String message;
    private String accountId;
    private String orderId;
    private Boolean submitted;
    private String clientOrderId;
    private String marketCode;
    private String status;
    private String side;
    private String price;
    private String stopPrice;
    private Boolean isTriggered;
    private String quantity;
    private String amount;
    private String remainQuantity;
    private String matchId;
    private String matchPrice;
    private String matchQuantity;
    private String feeInstrumentId;
    private String fees;
    private String orderType;
    private String triggerType;
    private String timeInForce;
    private String createdAt;
    private String lastModifiedAt;
    private String lastMatchedAt;
    private Integer source;
    private String displayQuantity;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(String remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

    public String getFeeInstrumentId() {
        return feeInstrumentId;
    }

    public void setFeeInstrumentId(String feeInstrumentId) {
        this.feeInstrumentId = feeInstrumentId;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getDisplayQuantity() {
        return displayQuantity;
    }

    public void setDisplayQuantity(String displayQuantity) {
        this.displayQuantity = displayQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("notice", notice)
                .append("code", code)
                .append("message", message)
                .append("accountId", accountId)
                .append("orderId", orderId)
                .append("submitted", submitted)
                .append("clientOrderId", clientOrderId)
                .append("marketCode", marketCode)
                .append("status", status)
                .append("side", side)
                .append("price", price)
                .append("stopPrice", stopPrice)
                .append("isTriggered", isTriggered)
                .append("quantity", quantity)
                .append("amount", amount)
                .append("remainQuantity", remainQuantity)
                .append("matchId", matchId)
                .append("matchPrice", matchPrice)
                .append("matchQuantity", matchQuantity)
                .append("feeInstrumentId", feeInstrumentId)
                .append("fees", fees)
                .append("orderType", orderType)
                .append("triggerType", triggerType)
                .append("timeInForce", timeInForce)
                .append("createdAt", createdAt)
                .append("lastModifiedAt", lastModifiedAt)
                .append("lastMatchedAt", lastMatchedAt)
                .append("source", source)
                .append("displayQuantity", displayQuantity)
                .toString();
    }
}
