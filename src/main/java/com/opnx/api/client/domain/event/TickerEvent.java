package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = TickerEventDeserializer.class)
public class TickerEvent {

  // {"table":"ticker","data":[{"last":"0","open24h":"0","high24h":"0","low24h":"0","volume24h":"0","currencyVolume24h":"0","openInterest":"0","marketCode":"BAL-USDT-REPO-LIN","timestamp":"1676361998754","lastQty":"0","markPrice":"0","lastMarkPrice":"0","indexPrice":"0"},
  private String	table;
  private List<TickerData>	data;

  public String getTable() {
    return this.table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public List<TickerData> getData() {
    return this.data;
  }

  public void setData(List<TickerData> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                   .append("table", table)
                   .append("data", data)
                   .toString();
  }


}
