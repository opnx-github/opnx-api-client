package com.opnx.api.client.impl;

import com.opnx.api.client.OpnxApiCallback;
import com.opnx.api.client.exception.OpnxApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Opnx API WebSocket listener.
 */
public class OpnxApiWebSocketListener<T> extends WebSocketListener {
  private static Logger logger = Logger.getLogger(OpnxApiWebSocketListener.class.getName());
  private OpnxApiCallback<T> callback;

  private static final ObjectMapper mapper = new ObjectMapper();

  private final ObjectReader objectReader;

  private boolean closing = false;

  private WebSocket webSocket;

  private String openMessage;

  public OpnxApiWebSocketListener(OpnxApiCallback<T> callback, Class<T> eventClass, String openMessage) {
    this.openMessage = openMessage;
    this.callback = callback;
    this.objectReader = mapper.readerFor(eventClass);
  }

  public OpnxApiWebSocketListener(OpnxApiCallback<T> callback, TypeReference<T> eventTypeReference, String openMessage) {
    this.openMessage = openMessage;
    this.callback = callback;
    this.objectReader = mapper.readerFor(eventTypeReference);
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    this.webSocket = webSocket;
    if(openMessage != null){
      webSocket.send(openMessage);
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
      T event = objectReader.readValue(text);
      callback.onResponse(event,this);
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
      callback.onFailure(t);
    }
  }

  public void send(String message) {
    //webSocket.send(Mapper.asString(message));
    webSocket.send(message);
  }
}