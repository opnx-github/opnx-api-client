package com.opnx.api.client.domain.messages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PlaceorderCommand{
    private static Logger logger = Logger.getLogger( PlaceorderCommand.class.getName());
    private String	op;
    private String	tag;
    private PlaceorderCommandData	data;

    public Map<String, Object> toMap() {
        Map<String, Object> raw = new HashMap<>();
        raw.put("op", this.op);
        raw.put("tag", this.tag);
        raw.put("data", this.data.toMap());
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

    public String getOp() {
      return this.op;
    }

    public void setOp(String op) {
      this.op = op;
    }

    public String getTag() {
      return this.tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

    public PlaceorderCommandData getData() {
      return this.data;
    }

    public void setData(PlaceorderCommandData data) {
      this.data = data;
    }

}
