package com.opnx.api.client.impl;

import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.config.OpnxApiConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;

/**
 * Opnx API WebSocket client implementation using OkHttp.
 */
public class OpnxApiWebSocketClientImpl implements OpnxApiWebSocketClient, Closeable {

    private final OkHttpClient client;

    public OpnxApiWebSocketClientImpl(OkHttpClient client) {
        this.client = client;
    }

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Override
    public void close() {
    }

    @Override
    public Closeable createNewWebSocket(OpnxApiWebSocketListener listener) {
        String streamingUrl = String.format("%s", OpnxApiConfig.useTestNetStreaming ? OpnxApiConfig.getStreamTestNetBaseUrl() : OpnxApiConfig.getStreamApiBaseUrl());
        Request request = new Request.Builder().url(streamingUrl).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            listener.onOpen(webSocket, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

    @Override
    public Closeable createNewWebSocket(MultipleCallbacksWebSocketListener listener) {
        String streamingUrl = String.format("%s", OpnxApiConfig.useTestNetStreaming ? OpnxApiConfig.getStreamTestNetBaseUrl() : OpnxApiConfig.getStreamApiBaseUrl());
        Request request = new Request.Builder().url(streamingUrl).build();
        final WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            listener.onOpen(webSocket, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }

    @Override
    public Closeable onTickerUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onPingEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onMarketUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onTradeUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onDepthUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onIncrementalOrderBookUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onBestBidAskUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public Closeable onCandlesUpdateEvent(OpnxApiWebSocketListener listener) {
        return createNewWebSocket(listener);
    }

    @Override
    public void onOrderUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage) {
        listener.send(subscribeMessage);
    }

    @Override
    public void onPositionUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage) {
        listener.send(subscribeMessage);
    }

    @Override
    public void onBalanceUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage) {
        listener.send(subscribeMessage);
    }
}
