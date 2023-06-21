package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = TradeEventDeserializer.class)
public class TradeEvent{

    private String	table;
    private List<TradeData> data;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("table", table)
                       .append("data", data)
                       .toString();
    }

    public String getTable() {
      return this.table;
    }

    public void setTable(String table) {
      this.table = table;
    }

    public List<TradeData> getData() {
      return this.data;
    }

    public void setData(List<TradeData> data) {
      this.data = data;
    }

}
