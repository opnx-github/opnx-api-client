package com.opnx.api.client.domain.event;

import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class BalanceEvent{

    private String	table;
    private String	accountId;
    private String	timestamp;
    private String	tradeType;
    private List<BalanceData> data;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("table", table)
                       .append("accountId", accountId)
                       .append("timestamp", timestamp)
                       .append("tradeType", tradeType)
                       .append("data", data)
                       .toString();
    }

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

    public String getTradeType() {
      return this.tradeType;
    }

    public void setTradeType(String tradeType) {
      this.tradeType = tradeType;
    }

    public List<BalanceData> getData() {
      return this.data;
    }

    public void setData(List<BalanceData> data) {
      this.data = data;
    }

}
