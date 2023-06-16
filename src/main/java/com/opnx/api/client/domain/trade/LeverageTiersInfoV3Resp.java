package com.opnx.api.client.domain.trade;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LeverageTiersInfoV3Resp {
    private String marketCode;
    private List<TiersResp> tiers;


    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public List<TiersResp> getTiers() {
        return tiers;
    }

    public void setTiers(List<TiersResp> tiers) {
        this.tiers = tiers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("tiers", tiers)
                .toString();
    }
}
