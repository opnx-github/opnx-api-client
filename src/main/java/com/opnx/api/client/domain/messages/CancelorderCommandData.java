package com.opnx.api.client.domain.messages;

public class CancelorderCommandData {

    private String	marketCode;
    private String	orderId;

    public String getMarketCode() {
        return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}

