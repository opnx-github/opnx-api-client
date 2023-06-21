package com.opnx.api.client.domain.funding;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingPaymentsV3Resp {
    private String id;
    private String marketCode;
    private String payment;
    private String fundingRate;
    private String position;
    private String indexPrice;
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(String fundingRate) {
        this.fundingRate = fundingRate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndexPrice() {
        return indexPrice;
    }

    public void setIndexPrice(String indexPrice) {
        this.indexPrice = indexPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("marketCode", marketCode)
                .append("payment", payment)
                .append("fundingRate", fundingRate)
                .append("position", position)
                .append("indexPrice", indexPrice)
                .append("createdAt", createdAt)
                .toString();
    }
}
