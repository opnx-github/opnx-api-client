package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionData{

    @JsonProperty("instrumentId")
    private String	instrumentId;
    @JsonProperty("quantity")
    private String	quantity;
    @JsonProperty("lastUpdated")
    private String	lastUpdated;
    @JsonProperty("contractValCurrency")
    private String	contractValCurrency;
    @JsonProperty("entryPrice")
    private String	entryPrice;
    @JsonProperty("positionPnl")
    private String	positionPnl;
    @JsonProperty("estLiquidationPrice")
    private String	estLiquidationPrice;
    @JsonProperty("margin")
    private String	margin;
    @JsonProperty("leverage")
    private String	leverage;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("instrumentId", instrumentId)
                       .append("quantity", quantity)
                       .append("lastUpdated", lastUpdated)
                       .append("contractValCurrency", contractValCurrency)
                       .append("entryPrice", entryPrice)
                       .append("positionPnl", positionPnl)
                       .append("estLiquidationPrice", estLiquidationPrice)
                       .append("margin", margin)
                       .append("leverage", leverage)
                       .toString();
    }

    public String getInstrumentId() {
      return this.instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
      this.instrumentId = instrumentId;
    }

    public String getQuantity() {
      return this.quantity;
    }

    public void setQuantity(String quantity) {
      this.quantity = quantity;
    }

    public String getLastUpdated() {
      return this.lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
      this.lastUpdated = lastUpdated;
    }

    public String getContractValCurrency() {
      return this.contractValCurrency;
    }

    public void setContractValCurrency(String contractValCurrency) {
      this.contractValCurrency = contractValCurrency;
    }

    public String getEntryPrice() {
      return this.entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
      this.entryPrice = entryPrice;
    }

    public String getPositionPnl() {
      return this.positionPnl;
    }

    public void setPositionPnl(String positionPnl) {
      this.positionPnl = positionPnl;
    }

    public String getEstLiquidationPrice() {
      return this.estLiquidationPrice;
    }

    public void setEstLiquidationPrice(String estLiquidationPrice) {
      this.estLiquidationPrice = estLiquidationPrice;
    }

    public String getMargin() {
      return this.margin;
    }

    public void setMargin(String margin) {
      this.margin = margin;
    }

    public String getLeverage() {
      return this.leverage;
    }

    public void setLeverage(String leverage) {
      this.leverage = leverage;
    }

}
