package com.opnx.api.client;

import com.opnx.api.client.impl.MultipleCallbacksWebSocketListener;

/**
 * OpnxApiCallback is a functional interface used together with the OpnxApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 */
@FunctionalInterface
public interface ApiCallback<T> {

    /**
     * Called whenever a response comes back from the Opnx API.
     *
     * @param event                                 the expected response object
     * @param multipleCallbacksApiWebSocketListener  multipleCallbacksApiWebSocketListener
     */
    void onResponse(T event, MultipleCallbacksWebSocketListener multipleCallbacksApiWebSocketListener);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {
    }


}