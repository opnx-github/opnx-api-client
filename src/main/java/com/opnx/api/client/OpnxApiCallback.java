package com.opnx.api.client;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;


/**
 * OpnxApiCallback is a functional interface used together with the OpnxApiRestAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
@FunctionalInterface
public interface OpnxApiCallback<T> {

    /**
     *  Called whenever a response comes back from the Opnx API.
     * @param event   opnx event
     * @param opnxApiWebSocketListener opnx api websocket listener
     */
    void onResponse(T event, OpnxApiWebSocketListener<T> opnxApiWebSocketListener);


    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {}
}