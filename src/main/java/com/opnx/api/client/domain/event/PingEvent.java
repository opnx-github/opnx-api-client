package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = PingEventDeserializer.class)
public class PingEvent {

  private String pong;
  private String event;

  public String getPong() {
    return pong;
  }

  public void setPong(String pong) {
    this.pong = pong;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                   .append("event", event)
                   .append("pong", pong)
                   .toString();
  }


}
