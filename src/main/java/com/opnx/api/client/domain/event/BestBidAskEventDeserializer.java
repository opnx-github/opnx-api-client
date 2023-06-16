package com.opnx.api.client.domain.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class BestBidAskEventDeserializer extends JsonDeserializer<BestBidAskEvent> {
    // {"table":"bestBidAsk","data":{"ask":"[]","checksum":0,"marketCode":"BTC-USDT-REPO-LIN","bid":[-0.0001,1.9],"timestamp":"1676540379626"}}
    private static Logger logger = Logger.getLogger( BestBidAskEventDeserializer.class.getName());
    @Override
    public BestBidAskEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        String json = node.toString();

        if(json.contains("\"table\":\"bestBidAsk\"")){
            try{
                BestBidAskEvent event = new BestBidAskEvent();
                // Parse header
                event.setTable(node.get("table").asText());

                // Parse candlestick data
                JsonNode data = node.get("data");
                if(!json.contains("\"ask\":\"[]\"")){
                    List<BigDecimal> ask = mapper.readerFor(new TypeReference<List<BigDecimal>>(){}).readValue(data.get("ask"));
                    event.setAsk(ask);
                }
                if(!json.contains("\"bid\":\"[]\"")){
                    List<BigDecimal> bid = mapper.readerFor(new TypeReference<List<BigDecimal>>(){}).readValue(data.get("bid"));
                    event.setBid(bid);
                }

                event.setChecksum(data.get("checksum").asLong());
                event.setMarketCode(data.get("marketCode").asText());
                event.setTimestamp(data.get("timestamp").asText());
                return event;
            }catch (Exception e) {
                logger.error("deserializer error: ", e);
            }
        }

        return null;
    }
}
