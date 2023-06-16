package com.opnx.api.client;


import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.impl.OpnxApiAsyncRestClientImpl;
import com.opnx.api.client.impl.OpnxApiRestClientImpl;
import com.opnx.api.client.impl.OpnxApiWebSocketClientImpl;

import static com.opnx.api.client.impl.OpnxApiServiceGenerator.getSharedClient;


/**
 * A factory for creating opnxAPi client objects.
 */
public class OpnxApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    /**
     * User generated, eg: "123"
     */
    private String nonce;

    /**
     * Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     */
    private String timestamp;

    /**
     * Instantiates a new opnx api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private OpnxApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
        OpnxApiConfig.useTestNet = false;
        OpnxApiConfig.useTestNetStreaming = false;
    }


    /**
     * Instantiates a new opnx api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private OpnxApiClientFactory(String apiKey, String secret, boolean useTestNet) {
        this.apiKey = apiKey;
        this.secret = secret;
        OpnxApiConfig.useTestNet = useTestNet;
        OpnxApiConfig.useTestNetStreaming = true;
    }


    /**
     * Instantiates a new opnx api client factory.
     *
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param nonce     User generated, eg: "123"
     * @param timestamp Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     */
    private OpnxApiClientFactory(String apiKey, String secret, String nonce, String timestamp) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.nonce = nonce;
        this.timestamp = timestamp;
        OpnxApiConfig.useTestNet = true;
        OpnxApiConfig.useTestNetStreaming = true;
    }

    /**
     * Instantiates a new opnx api client factory.
     *
     * @param apiKey              the API key
     * @param secret              the Secret
     * @param useTestNet          true if endpoint is test network URL; false if endpoint is production  API URL.
     * @param useTestNetStreaming true for  test network websocket streaming; false for no streaming.
     */
    private OpnxApiClientFactory(String apiKey, String secret, boolean useTestNet, boolean useTestNetStreaming) {
        this.apiKey = apiKey;
        this.secret = secret;
        OpnxApiConfig.useTestNet = useTestNet;
        OpnxApiConfig.useTestNetStreaming = useTestNetStreaming;

    }


    /**
     * @param apiKey              the API key
     * @param secret              the Secret
     * @param nonce               User generated, eg: "123"
     * @param timestamp           Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     * @param useTestNet          true if endpoint is test network URL; false if endpoint is production  API URL.
     * @param useTestNetStreaming true for test network websocket streaming; false for no streaming.
     */
    private OpnxApiClientFactory(String apiKey, String secret, String nonce, String timestamp, boolean useTestNet, boolean useTestNetStreaming) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.nonce = nonce;
        this.timestamp = timestamp;
        OpnxApiConfig.useTestNet = useTestNet;
        OpnxApiConfig.useTestNetStreaming = useTestNetStreaming;

    }


    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the opnx api client factory
     */
    public static OpnxApiClientFactory newInstance(String apiKey, String secret) {
        return new OpnxApiClientFactory(apiKey, secret);
    }

    /**
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param nonce     User generated, eg: "123"
     * @param timestamp Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     * @return the opnx api client factory
     */
    public static OpnxApiClientFactory newInstance(String apiKey, String secret, String nonce, String timestamp) {
        return new OpnxApiClientFactory(apiKey, secret, nonce, timestamp);
    }


    /**
     * New instance with optional Test Network endpoint.
     *
     * @param apiKey              the API key
     * @param secret              the Secret
     * @param useTestNet          true if endpoint is test network URL; false if endpoint is production API URL.
     * @param useTestNetStreaming true for test network websocket streaming; false for no streaming.
     * @return the opnx api client factory.
     */
    public static OpnxApiClientFactory newInstance(String apiKey, String secret, boolean useTestNet, boolean useTestNetStreaming) {
        return new OpnxApiClientFactory(apiKey, secret, useTestNet, useTestNetStreaming);
    }

    /**
     * New instance with optional Test Network endpoint.
     *
     * @param apiKey              the API key
     * @param secret              the Secret
     * @param nonce               User generated, eg: "123"
     * @param timestamp           Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     * @param useTestNet          true if endpoint is test network URL; false if endpoint is production API URL.
     * @param useTestNetStreaming true for test network websocket streaming; false for no streaming.
     * @return the opnx api client factory.
     */
    public static OpnxApiClientFactory newInstance(String apiKey, String secret, String nonce, String timestamp, boolean useTestNet, boolean useTestNetStreaming) {
        return new OpnxApiClientFactory(apiKey, secret, nonce, timestamp, useTestNet, useTestNetStreaming);
    }


    /**
     * New instance without authentication.
     *
     * @return the opnx api client factory
     */
    public static OpnxApiClientFactory newInstance() {
        return new OpnxApiClientFactory(null, null);
    }

    /**
     * New instance without authentication. Users can provide nonce and timestamp
     *
     * @param nonce     User generated, eg: "123"
     * @param timestamp Timestamp , eg: YYYY-MM-DDThh:mm:ss  "2020-04-30T15:20:30"
     * @return the opnx api client factory
     */
    public static OpnxApiClientFactory newInstanceWithNonceAndTimestamp(String nonce, String timestamp) {
        return new OpnxApiClientFactory(null, null, nonce, timestamp);
    }

    /**
     * New instance without authentication and with optional Test Network endpoint.
     *
     * @param useTestNet          true if endpoint is test network URL; false if endpoint is production API URL.
     * @param useTestNetStreaming true for test network websocket streaming; false for no streaming.
     * @return the opnx api client factory.
     */
    public static OpnxApiClientFactory newInstance(boolean useTestNet, boolean useTestNetStreaming) {
        return new OpnxApiClientFactory(null, null, useTestNet, useTestNetStreaming);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public OpnxApiRestClient newRestClient() {
        return new OpnxApiRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public OpnxApiRestClient newRestClientWithNonceAndTimestamp() {
        return new OpnxApiRestClientImpl(apiKey, secret, nonce, timestamp);
    }


    /**
     * Creates a new web socket client used for handling data streams.
     */
    public OpnxApiWebSocketClient newWebSocketClient() {
        return new OpnxApiWebSocketClientImpl(getSharedClient());
    }


    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public OpnxApiRestAsyncClient newAsyncRestClient() {
        return new OpnxApiAsyncRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public OpnxApiRestAsyncClient newAsyncRestClientWithNonceAndTimestamp() {
        return new OpnxApiAsyncRestClientImpl(apiKey, secret, nonce, timestamp);
    }


}
