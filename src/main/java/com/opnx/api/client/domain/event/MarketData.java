package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData{

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("marketId", marketId)
                       .append("marketCode", marketCode)
                       .append("name", name)
                       .append("referencePair", referencePair)
                       .append("base", base)
                       .append("counter", counter)
                       .append("type", type)
                       .append("exclusive", exclusive)
                       .append("tickSize", tickSize)
                       .append("qtyIncrement", qtyIncrement)
                       .append("marginCurrency", marginCurrency)
                       .append("contractValCurrency", contractValCurrency)
                       .append("upperPriceBound", upperPriceBound)
                       .append("lowerPriceBound", lowerPriceBound)
                       .append("marketPrice", marketPrice)
                       .append("fundingRate", fundingRate)
                       .toString();
    }

    @JsonProperty("marketId")
    private String	marketId;
    @JsonProperty("marketCode")
    private String	marketCode;
    @JsonProperty("name")
    private String	name;
    @JsonProperty("referencePair")
    private String	referencePair;
    @JsonProperty("base")
    private String	base;
    @JsonProperty("counter")
    private String	counter;
    @JsonProperty("type")
    private String	type;
    @JsonProperty("exclusive")
    private String	exclusive;
    @JsonProperty("tickSize")
    private String	tickSize;
    @JsonProperty("qtyIncrement")
    private String	qtyIncrement;
    @JsonProperty("marginCurrency")
    private String	marginCurrency;
    @JsonProperty("contractValCurrency")
    private String	contractValCurrency;
    @JsonProperty("upperPriceBound")
    private String	upperPriceBound;
    @JsonProperty("lowerPriceBound")
    private String	lowerPriceBound;
    @JsonProperty("marketPrice")
    private String	marketPrice;
    @JsonProperty("fundingRate")
    private String	fundingRate;



    public String getMarketId() {
      return this.marketId;
    }

    public void setMarketId(String marketId) {
      this.marketId = marketId;
    }

    public String getMarketCode() {
      return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
      this.marketCode = marketCode;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getReferencePair() {
      return this.referencePair;
    }

    public void setReferencePair(String referencePair) {
      this.referencePair = referencePair;
    }

    public String getBase() {
      return this.base;
    }

    public void setBase(String base) {
      this.base = base;
    }

    public String getCounter() {
      return this.counter;
    }

    public void setCounter(String counter) {
      this.counter = counter;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getExclusive() {
      return this.exclusive;
    }

    public void setExclusive(String exclusive) {
      this.exclusive = exclusive;
    }

    public String getTickSize() {
      return this.tickSize;
    }

    public void setTickSize(String tickSize) {
      this.tickSize = tickSize;
    }

    public String getQtyIncrement() {
      return this.qtyIncrement;
    }

    public void setQtyIncrement(String qtyIncrement) {
      this.qtyIncrement = qtyIncrement;
    }

    public String getMarginCurrency() {
      return this.marginCurrency;
    }

    public void setMarginCurrency(String marginCurrency) {
      this.marginCurrency = marginCurrency;
    }

    public String getContractValCurrency() {
      return this.contractValCurrency;
    }

    public void setContractValCurrency(String contractValCurrency) {
      this.contractValCurrency = contractValCurrency;
    }

    public String getUpperPriceBound() {
      return this.upperPriceBound;
    }

    public void setUpperPriceBound(String upperPriceBound) {
      this.upperPriceBound = upperPriceBound;
    }

    public String getLowerPriceBound() {
      return this.lowerPriceBound;
    }

    public void setLowerPriceBound(String lowerPriceBound) {
      this.lowerPriceBound = lowerPriceBound;
    }

    public String getMarketPrice() {
      return this.marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
      this.marketPrice = marketPrice;
    }

    public String getFundingRate() {
      return this.fundingRate;
    }

    public void setFundingRate(String fundingRate) {
      this.fundingRate = fundingRate;
    }

}
