package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opnx.api.client.domain.messages.LoginCommand;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *
 *
 * @see
 */
public class LoginEventDeserializer extends JsonDeserializer<LoginEvent> {
  private static Logger logger = Logger.getLogger( LoginCommand.class.getName());
  private ObjectMapper mapper;

  @Override
  public LoginEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {

    if (mapper == null) {
      mapper = new ObjectMapper();
    }

    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);
    String json = node.toString();



    if(json.contains("\"event\":\"login\"")){
      try{
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setTag(node.get("tag").asText());
        loginEvent.setEvent(node.get("event").asText());
        loginEvent.setSuccess(node.get("success").asBoolean());
        loginEvent.setTimestamp(node.get("timestamp").asText());
        return loginEvent;
      }catch (Exception e) {
        logger.error("deserializer error: ", e);
      }
    }
    return null;
  }


}
