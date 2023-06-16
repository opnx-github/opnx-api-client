package com.opnx.api.client.domain.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LoginCommandData {
    private static Logger logger = Logger.getLogger( LoginCommandData.class.getName());
    private String	apiKey;
    private String	timestamp;
    private String	signature;

    public Map<String, Object> toMap() {
        Map<String, Object> raw = new HashMap<>();
        raw.put("apiKey", this.apiKey);
        raw.put("timestamp", this.timestamp);
        raw.put("signature", this.signature);
        /* more fields */
        return raw;
    }

    @Override
    public String toString() {
        // add JSON processing exception handling, dropped for readability
        try {
            return new ObjectMapper().writeValueAsString(this.toMap());
        } catch (JsonProcessingException e) {
            logger.error("toString error: ", e);
        }
        return null;
    }

    public String getApiKey() {
      return this.apiKey;
    }

    public void setApiKey(String apiKey) {
      this.apiKey = apiKey;
    }

    public String getTimestamp() {
      return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
    }

    public String getSignature() {
      return this.signature;
    }

    public void setSignature(String signature) {
      this.signature = signature;
    }

}
