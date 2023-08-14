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
public class CandlesEventDeserializer extends JsonDeserializer<CandlesEvent> {
  private static Logger logger = Logger.getLogger( CandlesEventDeserializer.class.getName());
  private ObjectMapper mapper;

  @Override
  public CandlesEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();



    if(json.contains("\"table\":\"candles60s\"")){
      try{
        CandlesEvent event = new CandlesEvent();

        List<CandlesData> data = mapper.readerFor(new TypeReference<List<CandlesData>>(){}).readValue(node.get("data"));
        event.setTable(node.get("table").asText());
        event.setData(data);
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
