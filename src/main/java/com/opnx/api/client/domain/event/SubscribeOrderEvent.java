package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = SubscribeOrderEventDeserializer.class)
public class SubscribeOrderEvent {

    private String	table;
    private List<SubscribeOrderData> data;

    public String getTable() {
      return this.table;
    }

    public void setTable(String table) {
      this.table = table;
    }

    public List<SubscribeOrderData> getData() {
      return this.data;
    }

    public void setData(List<SubscribeOrderData> data) {
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
