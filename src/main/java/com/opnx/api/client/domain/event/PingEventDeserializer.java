package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *
 *
 * @see
 */
public class PingEventDeserializer extends JsonDeserializer<PingEvent> {
  private static Logger logger = Logger.getLogger( PingEventDeserializer.class.getName());
  private ObjectMapper mapper;

  @Override
  public PingEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();

    if(json.contains("pong")){
      try{
        PingEvent event = new PingEvent();
        event.setPong("pong");
        event.setEvent(node.get("event").asText());
        return event;
      }catch (Exception e) {
        logger.error("deserializer error: ", e);
      }
    }
    return null;
  }


}
