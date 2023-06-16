package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeData {

    @JsonProperty("side")
    private String	side;
    @JsonProperty("quantity")
    private String	quantity;
    @JsonProperty("matchType")
    private String	matchType;
    @JsonProperty("price")
    private String	price;
    @JsonProperty("marketCode")
    private String	marketCode;
    @JsonProperty("tradeId")
    private String	tradeId;
    @JsonProperty("timestamp")
    private String	timestamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("side", side)
                       .append("quantity", quantity)
                       .append("matchType", matchType)
                       .append("price", price)
                       .append("marketCode", marketCode)
                       .append("tradeId", tradeId)
                       .append("timestamp", timestamp)
                       .toString();
    }

    public String getSide() {
      return this.side;
    }

    public void setSide(String side) {
      this.side = side;
    }

    public String getQuantity() {
      return this.quantity;
    }

    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    public String getMatchType() {
      return this.matchType;
    }

    public void setMatchType(String matchType) {
      this.matchType = matchType;
    }

    public String getPrice() {
      return this.price;
    }

    public void setPrice(String price) {
      this.price = price;
    }

    public String getMarketCode() {
      return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
      this.marketCode = marketCode;
    }

    public String getTradeId() {
      return this.tradeId;
    }

    public void setTradeId(String tradeId) {
      this.tradeId = tradeId;
    }

    public String getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }

}
