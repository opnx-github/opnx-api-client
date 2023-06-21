package com.opnx.api.client.domain.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PlaceorderCommandData {
    private static Logger logger = Logger.getLogger( PlaceorderCommandData.class.getName());
    private String	timestamp;
    private String	recvWindow;
    private String	clientOrderId;
    private String	marketCode;
    private String	side;
    private String	orderType;
    private String	quantity;
    private String	timeInForce;
    private String	price;
    private String	stopPrice;
    private String	limitPrice;

    public Map<String, Object> toMap() {
        Map<String, Object> raw = new HashMap<>();
        raw.put("timestamp", this.timestamp);
        raw.put("recvWindow", this.recvWindow);
        raw.put("clientOrderId", this.clientOrderId);
        raw.put("marketCode", this.marketCode);
        raw.put("side", this.side);
        raw.put("orderType", this.orderType);
        raw.put("quantity", this.quantity);
        raw.put("timeInForce", this.timeInForce);
        raw.put("price", this.price);
        /* more fields */
        return raw;
    }

    @Override
    public String toString() {
        // add JSON processing exception handling, dropped for readability
        try {
            return new ObjectMapper().writeValueAsString(this.toMap());
        } catch (JsonProcessingException e) {
            logger.error("toString error: ", e);
        }
        return null;
    }

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

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getSide() {
        return this.side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTimeInForce() {
        return this.timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getPrice() {
        return this.price;
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

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }
}