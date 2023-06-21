package com.opnx.api.client.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.opnx.api.client.CallbackAndEvent;
import com.opnx.api.client.ApiCallback;
import com.opnx.api.client.domain.event.*;
import com.opnx.api.client.exception.OpnxApiException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Opnx API WebSocket listener.
 */
public class MultipleCallbacksWebSocketListener extends WebSocketListener {
  private static Logger logger = Logger.getLogger(MultipleCallbacksWebSocketListener.class.getName());
  private Map<String,ApiCallback> callbackMap;

  private static final ObjectMapper mapper = new ObjectMapper();

  private Map<String,ObjectReader> objectReaderMap;

  private static final Map<String,String> event2ClassNameMap;

  private boolean closing = false;

  private WebSocket webSocket;

  private String openMessage;

  static {
    event2ClassNameMap = new HashMap<>();
    event2ClassNameMap.put("placeorder", PlaceOrderEvent.class.getName()); //"event":"placeorder"
    event2ClassNameMap.put("modifyorder", ModifyOrderEvent.class.getName()); //"event":"modifyorder"
    event2ClassNameMap.put("cancelorder", CancelOrderEvent.class.getName()); //"event":"cancelorder"
    event2ClassNameMap.put("login",LoginEvent.class.getName()); //"event":"login"
    event2ClassNameMap.put("ping", PingEvent.class.getName()); //"event":"ping"

    event2ClassNameMap.put("balance", BalanceEvent.class.getName()); //"table":"balance"
    event2ClassNameMap.put("depth",DepthEvent.class.getName()); //"table":"depth"
    event2ClassNameMap.put("candles60s",CandlesEvent.class.getName()); //"table":"candles60s"
    event2ClassNameMap.put("market",MarketEvent.class.getName()); //"table":"market"
    event2ClassNameMap.put("bestBidAsk",BestBidAskEvent.class.getName()); //"table":"bestBidAsk"
    event2ClassNameMap.put("ticker",BestBidAskEvent.class.getName()); //"table":"ticker"
    event2ClassNameMap.put("position", PositionEvent.class.getName()); //"table":"position"
    event2ClassNameMap.put("order", SubscribeOrderEvent.class.getName()); //"table":"order"
    event2ClassNameMap.put("depthUpdate", OrderBookEvent.class.getName());
    event2ClassNameMap.put("depthUpdate-diff", IncrementalOrderBookEvent.class.getName());
    event2ClassNameMap.put("trade", TradeEvent.class.getName());
    event2ClassNameMap.put("liquidationRFQ", LiquidationRFQEvent.class.getName());


    /*
    *
    public static final String ORDER_AGG_STATUS_CHANNEL = "aggOrder";
    public static final String DEPTH_FUTURES_CHANNEL = "futures/depth";
    public static final String CANDLES = "candles";
    public static final String ALL_TOPIC = "all";
    public static final String DEPTH_L5_CHANNEL = "depthL5";
    public static final String DEPTH_L10_CHANNEL = "depthL10";
    public static final String DEPTH_L25_CHANNEL = "depthL25";
    public static final String APP_TOPIC = "app";
    *
    * */
  }


  public MultipleCallbacksWebSocketListener(Map<String,CallbackAndEvent> callbackAndEvent, String openMessage) {
    this.openMessage = openMessage;
    callbackMap = new HashMap<>();
    objectReaderMap = new HashMap<>();
    for (Map.Entry<String,CallbackAndEvent> entry : callbackAndEvent.entrySet()) {
      callbackMap.put(entry.getKey(),entry.getValue().getCallback());
      objectReaderMap.put(entry.getKey(),mapper.readerFor(entry.getValue().getEventClass()));
    }
  }

  /*public OpnxApiWebSocketListener(ApiCallback<T> callback, TypeReference<T> eventTypeReference, String openMessage) {
    this.openMessage = openMessage;
    this.callback = callback;
    this.objectReader = mapper.readerFor(eventTypeReference);
  }*/

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    this.webSocket = webSocket;
    if(openMessage != null){
      webSocket.send(openMessage);
    }
  }

  private void onEvent(String text, String event) throws IOException {
    String eventName = event2ClassNameMap.get(event);
    if(eventName != null && objectReaderMap.get(eventName) != null) {
      callbackMap.get(eventName).onResponse(objectReaderMap.get(eventName).readValue(text),this);
    }else{
      logger.info(event+ " unprocessed");
    }
  }

  private void onTable(String text, String table) throws IOException {
    String eventName = event2ClassNameMap.get(table);
    if(eventName != null && objectReaderMap.get(eventName) != null) {
      callbackMap.get(eventName).onResponse(objectReaderMap.get(eventName).readValue(text),this);
    }else{
      logger.info(table+ " unprocessed");
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    logger.info("websocket receive msg " + text);
    if(text.contains("\"event\":\"Welcome\"")){
      return;
    }
    if(!"pong".equals(text)){

    }else{
      text = "{\"event\":\"ping\",\"pong\":\"pong\"}";
    }
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode rootNode = mapper.readTree(text);
      String table = rootNode.get("table") == null ? null:rootNode.get("table").asText();
      String event = rootNode.get("event") == null ? null:rootNode.get("event").asText();
      if(rootNode.get("table") == null){
        onEvent(text,event);
      }else{
        onTable(text,table);
      }
    } catch (IOException e) {
      logger.error("onMessage: ", e);
      throw new OpnxApiException(e);
    }
  }

  @Override
  public void onClosing(final WebSocket webSocket, final int code, final String reason) {
    closing = true;
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    if (!closing) {
      t.printStackTrace();
      for (Map.Entry<String,ApiCallback> entry : callbackMap.entrySet()) {
        entry.getValue().onFailure(t);
      }
    }
  }

  public void send(String message) {
    //webSocket.send(Mapper.asString(message));
    webSocket.send(message);
  }
}