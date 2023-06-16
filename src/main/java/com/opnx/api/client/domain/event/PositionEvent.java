package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = PositionEventDeserializer.class)
public class PositionEvent{

    private String	table;
    private String	accountId;
    private String	timestamp;
    private List<PositionData>	data;

    public String getTable() {
      return this.table;
    }

    public void setTable(String table) {
      this.table = table;
    }

    public String getAccountId() {
      return this.accountId;
    }

    public void setAccountId(String accountId) {
      this.accountId = accountId;
    }

    public String getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }

    public List<PositionData> getData() {
      return this.data;
    }

    public void setData(List<PositionData> data) {
      this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("table", table)
                       .append("accountId", accountId)
                       .append("timestamp", timestamp)
                       .append("data", data)
                       .toString();
    }
}
