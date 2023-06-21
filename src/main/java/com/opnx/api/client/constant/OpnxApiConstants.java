package com.opnx.api.client.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Opnx's API.
 */
public class OpnxApiConstants {
    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "AccessKey";

    public static final String TIMESTAMP = "Timestamp";

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String NONCE = "Nonce";

    public static final String UTC = "UTC";

    /**
     * Decorator to indicate that an endpoint requires a signature.
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "Signature";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

    /**
     * Default receiving window.
     */
    public static final long DEFAULT_RECEIVING_WINDOW = 60000L;

    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     * - Example ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.JSON_STYLE;

}
