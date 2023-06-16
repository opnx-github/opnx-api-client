package com.opnx.api.client.domain.messages;

public class ModifyorderCommandData {

    private String	timestamp;
    private String	recvWindow;
    private String	marketCode;
    private String	orderId;
    private String	side;
    private String	price;
    private String	quantity;

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRecvWindow() {
        return this.recvWindow;
    }

    public void setRecvWindow(String recvWindow) {
        this.recvWindow = recvWindow;
    }

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

    public String getSide() {
        return this.side;
    }

    public void setSide(String side) {
        this.side = side;
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

}
