package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = LoginEventDeserializer.class)
public class LoginEvent {

  private String message;
  private String code;
  private String tag;
  private String event;
  private boolean success;
  private String timestamp;

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
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
                   .append("tag", tag)
                   .append("event", event)
                   .append("success", success)
                   .append("timestamp", timestamp)
                   .toString();
  }


}
