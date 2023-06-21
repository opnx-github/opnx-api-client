package com.opnx.api.client.config;

/**
 * Configuration used for Opnx operations.
 */
public class OpnxApiConfig {

    /**
     * Account Api key
     */
    public static final String API_KEY = "<please use your key instead>";

    /**
     * Account Api key secret
     */

    public static final String API_KEY_SECRET = "<please use your key secret instead>";

    /**
     * Base domain for URLs.
     */
    public static String BASE_DOMAIN = "api.opnx.com";

    /**
     * Test Network URL.
     */
    public static final String TESTNET_DOMAIN = "stgapi.opnx.com";


    public static final String WS_URL = "wss://%s/v2/websocket";

    /**
     * Opnx Test Network option:
     * true if endpoint is  test network URL; false if endpoint is production API URL.
     */
    public static boolean useTestNet;

    /**
     * Opnx  Test Network option:
     * true for websocket streaming; false for no streaming.
     */
    public static boolean useTestNetStreaming;

    /**
     * Set the URL base domain name (e.g., v2api.opnx.com).
     *
     * @param baseDomain Base domain name
     */
    public static void setBaseDomain(final String baseDomain) {
        BASE_DOMAIN = baseDomain;
    }

    /**
     * Get the URL base domain name (e.g., v2api.opnx.com).
     *
     * @return The base domain for URLs
     */
    public static String getBaseDomain() {
        return BASE_DOMAIN;
    }

    /**
     * REST API base URL.
     */
    public static String getApiBaseUrl() {
        return String.format("https://%s", getBaseDomain());
    }

    /**
     * Streaming API base URL.
     */
    public static String getStreamApiBaseUrl() {
        return String.format(WS_URL, getBaseDomain());
    }

    /**
     * Asset info base URL.
     */
    public static String getAssetInfoApiBaseUrl() {
        return String.format("https://%s/", getBaseDomain());
    }

    /**
     * Test Network API base URL.
     */
    public static String getTestNetBaseUrl() {
        return String.format("https://%s", TESTNET_DOMAIN);
    }

    /**
     * Streaming Test Network base URL.
     * wss://api-durian.cfdev.pro/v2/websocket
     */
    public static String getStreamTestNetBaseUrl() {
        return String.format(WS_URL, TESTNET_DOMAIN);
    }
}
