package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceData {

    @JsonProperty("instrumentId")
    private String	instrumentId;
    @JsonProperty("total")
    private String	total;
    @JsonProperty("available")
    private String	available;
    @JsonProperty("reserved")
    private String	reserved;
    @JsonProperty("quantityLastUpdated")
    private String	quantityLastUpdated;
    @JsonProperty("locked")
    private String	locked;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("instrumentId", instrumentId)
                       .append("total", total)
                       .append("available", available)
                       .append("reserved", reserved)
                       .append("quantityLastUpdated", quantityLastUpdated)
                       .append("locked", locked)
                       .toString();
    }

    public String getInstrumentId() {
      return this.instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
      this.instrumentId = instrumentId;
    }

    public String getTotal() {
      return this.total;
    }

    public void setTotal(String total) {
      this.total = total;
    }

    public String getAvailable() {
      return this.available;
    }

    public void setAvailable(String available) {
      this.available = available;
    }

    public String getReserved() {
      return this.reserved;
    }

    public void setReserved(String reserved) {
      this.reserved = reserved;
    }

    public String getQuantityLastUpdated() {
      return this.quantityLastUpdated;
    }

    public void setQuantityLastUpdated(String quantityLastUpdated) {
      this.quantityLastUpdated = quantityLastUpdated;
    }

    public String getLocked() {
      return this.locked;
    }

    public void setLocked(String locked) {
      this.locked = locked;
    }

}
