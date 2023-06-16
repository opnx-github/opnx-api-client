package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = OrderBookEventDeserializer.class)
public class OrderBookEvent {

  private String	table;
  private OrderBookData	data;
  private String	action;

  public String getTable() {
    return this.table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public OrderBookData getData() {
    return this.data;
  }

  public void setData(OrderBookData data) {
    this.data = data;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                   .append("table", table)
                   .append("data", data)
                   .append("action", action)
                   .toString();
  }


}
