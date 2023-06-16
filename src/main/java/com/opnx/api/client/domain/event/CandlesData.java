package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CandlesData {

    @JsonProperty("candle")
    private List<String> candle;
    @JsonProperty("marketCode")
    private String	marketCode;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("candle", candle)
                       .append("marketCode", marketCode)
                       .toString();
    }

    public List<String> getCandle() {
      return this.candle;
    }

    public void setCandle(List<String> candle) {
      this.candle = candle;
    }

    public String getMarketCode() {
      return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
      this.marketCode = marketCode;
    }

}
