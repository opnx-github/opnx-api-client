package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ModifyOrderEventDeserializer.class)
public class ModifyOrderEvent {

    private Boolean	success;
    private String	event;
    private Boolean	submitted;
    private String	tag;
    private String	message;
    private String	code;
    private String	timestamp;
    private OrderData data;

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                       .append("event", event)
                       .append("submitted", submitted)
                       .append("tag", tag)
                       .append("message", message)
                       .append("code", code)
                       .append("timestamp", timestamp)
                       .append("data", data)
                       .toString();
    }

    public String getEvent() {
      return this.event;
    }

    public void setEvent(String event) {
      this.event = event;
    }

    public Boolean getSubmitted() {
      return this.submitted;
    }

    public void setSubmitted(Boolean submitted) {
      this.submitted = submitted;
    }

    public String getTag() {
      return this.tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

    public String getMessage() {
      return this.message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public String getCode() {
      return this.code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }

    public OrderData getData() {
      return this.data;
    }

    public void setData(OrderData data) {
      this.data = data;
    }

}
