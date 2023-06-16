package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthData {

    @JsonProperty("seqNum")
    private Long seqNum;
    @JsonProperty("asks")
    private List<List<Integer>> asks;
    @JsonProperty("bids")
    private List<List<Integer>>	bids;
    @JsonProperty("checksum")
    private Long	checksum;
    @JsonProperty("marketCode")
    private String	marketCode;
    @JsonProperty("timestamp")
    private Long	timestamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("seqNum", seqNum)
                       .append("asks", asks)
                       .append("bids", bids)
                       .append("checksum", checksum)
                       .append("marketCode", marketCode)
                       .append("timestamp", timestamp)
                       .toString();
    }

    public Long getSeqNum() {
      return this.seqNum;
    }

    public void setSeqNum(Long seqNum) {
      this.seqNum = seqNum;
    }

    public List<List<Integer>> getAsks() {
      return this.asks;
    }

    public void setAsks(List<List<Integer>> asks) {
      this.asks = asks;
    }

    public List<List<Integer>> getBids() {
      return this.bids;
    }

    public void setBids(List<List<Integer>> bids) {
      this.bids = bids;
    }

    public Long getChecksum() {
      return this.checksum;
    }

    public void setChecksum(Long checksum) {
      this.checksum = checksum;
    }

    public String getMarketCode() {
      return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
      this.marketCode = marketCode;
    }

    public Long getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
    }

}
