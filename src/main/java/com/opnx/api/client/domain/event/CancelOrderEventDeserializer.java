package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opnx.api.client.exception.OpnxApiException;
import org.apache.log4j.Logger;

import java.io.IOException;
public class CancelOrderEventDeserializer extends JsonDeserializer<CancelOrderEvent> {
  private static Logger logger = Logger.getLogger( CancelOrderEventDeserializer.class.getName());
  private ObjectMapper mapper;

  @Override
  public CancelOrderEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();

    if(json.contains("\"event\":\"cancelorder\"")){
      try{
        CancelOrderEvent event = new CancelOrderEvent();
        OrderData data = getEventDetail(getJsonNode(node,"data").toString(), OrderData.class, mapper);
        event.setEvent(getString(node,"event"));
        event.setSubmitted(getBoolean(node,"submitted"));
        event.setTag(getString(node,"tag"));
        event.setMessage(getString(node,"message"));
        event.setCode(getString(node,"code"));
        event.setTimestamp(getString(node,"timestamp"));
        event.setData(data);
        return event;
      }catch (Exception e) {
        logger.error("deserializer error: ", e);
      }
    }

    return null;
  }

  private JsonNode getJsonNode(JsonNode node,String field){
    return node.get(field) == null ? null : node.get(field);
  }

  private String getString(JsonNode node,String field){
    return node.get(field) == null ? null : node.get(field).asText();
  }

  private Boolean getBoolean(JsonNode node,String field){
    return node.get(field) == null ? null : node.get(field).asBoolean();
  }

  public <T> T getEventDetail(String json, Class<T> clazz, ObjectMapper mapper) {
    try {
      return mapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new OpnxApiException(e);
    }
  }


}
