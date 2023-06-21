package com.opnx.api.client.domain.event;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = BestBidAskEventDeserializer.class)
public class BestBidAskEvent {

  // {"table":"bestBidAsk","data":{"ask":"[]","checksum":0,"marketCode":"BTC-USDT-REPO-LIN","bid":[-0.0001,1.9],"timestamp":"1676540379626"}}
  private String table;
  private List<BigDecimal> ask;
  private Long checksum;
  private String marketCode;
  private List<BigDecimal> bid;
  private String timestamp;


  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public List<BigDecimal> getAsk() {
    return ask;
  }

  public void setAsk(List<BigDecimal> ask) {
    this.ask = ask;
  }

  public Long getChecksum() {
    return checksum;
  }

  public void setChecksum(Long checksum) {
    this.checksum = checksum;
  }

  public String getMarketCode() {
    return marketCode;
  }

  public void setMarketCode(String marketCode) {
    this.marketCode = marketCode;
  }

  public List<BigDecimal> getBid() {
    return bid;
  }

  public void setBid(List<BigDecimal> bid) {
    this.bid = bid;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                   .append("table", table)
                   .append("ask", JSON.toJSON(ask))
                   .append("checksum", checksum)
                   .append("marketCode", marketCode)
                   .append("bid", bid)
                   .append("timestamp", timestamp)
                   .toString();
  }


}
