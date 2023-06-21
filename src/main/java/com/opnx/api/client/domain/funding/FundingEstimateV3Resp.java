package com.opnx.api.client.domain.funding;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FundingEstimateV3Resp {
    private String marketCode;
    private String fundingAt;
    private String estFundingRate;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getFundingAt() {
        return fundingAt;
    }

    public void setFundingAt(String fundingAt) {
        this.fundingAt = fundingAt;
    }

    public String getEstFundingRate() {
        return estFundingRate;
    }

    public void setEstFundingRate(String estFundingRate) {
        this.estFundingRate = estFundingRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("fundingAt", fundingAt)
                .append("estFundingRate", estFundingRate)
                .toString();
    }
}
