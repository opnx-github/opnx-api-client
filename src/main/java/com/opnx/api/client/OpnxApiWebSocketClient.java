package com.opnx.api.client;


import com.opnx.api.client.impl.MultipleCallbacksWebSocketListener;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;

import java.io.Closeable;

/**
 * Opnx API data streaming facade, supporting streaming of events through web sockets.
 */
public interface OpnxApiWebSocketClient extends Closeable {

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Deprecated
    void close();

    Closeable createNewWebSocket(OpnxApiWebSocketListener listener);

    Closeable createNewWebSocket(MultipleCallbacksWebSocketListener listener);

    Closeable onTickerUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onPingEvent(OpnxApiWebSocketListener listener);

    Closeable onMarketUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onTradeUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onDepthUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onIncrementalOrderBookUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onBestBidAskUpdateEvent(OpnxApiWebSocketListener listener);

    Closeable onCandlesUpdateEvent(OpnxApiWebSocketListener listener);

    void onOrderUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage);

    void onPositionUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage);

    void onBalanceUpdateEvent(MultipleCallbacksWebSocketListener listener, String subscribeMessage);
}
