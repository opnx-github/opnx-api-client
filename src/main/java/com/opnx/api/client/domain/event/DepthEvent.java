package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = DepthEventDeserializer.class)
public class DepthEvent{

    private String	table;
    private DepthData	data;
    private String	action;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("table", table)
                       .append("data", data)
                       .append("action", action)
                       .toString();
    }

    public String getTable() {
      return this.table;
    }

    public void setTable(String table) {
      this.table = table;
    }

    public DepthData getData() {
      return this.data;
    }

    public void setData(DepthData data) {
      this.data = data;
    }

    public String getAction() {
      return this.action;
    }

    public void setAction(String action) {
      this.action = action;
    }

}
