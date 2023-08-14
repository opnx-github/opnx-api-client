package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opnx.api.client.exception.OpnxApiException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class PositionEventDeserializer extends JsonDeserializer<PositionEvent> {
  private static Logger logger = Logger.getLogger( PositionEventDeserializer.class.getName());
  private ObjectMapper mapper;

  @Override
  public PositionEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();



    if(json.contains("\"table\":\"position\"")){
      try{
        PositionEvent event = new PositionEvent();
        List<PositionData> data = mapper.readerFor(new TypeReference<List<PositionData>>(){}).readValue(node.get("data"));
        event.setTable(node.get("table").asText());
        event.setData(data);
        event.setAccountId(node.get("accountId").asText());
        event.setTimestamp(node.get("timestamp").asText());
        return event;
      }catch (Exception e) {
        logger.error("deserializer error: ", e);
      }
    }

    return null;
  }

  public <T> T getEventDetail(String json, Class<T> clazz, ObjectMapper mapper) {
    try {
      return mapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new OpnxApiException(e);
    }
  }


}
