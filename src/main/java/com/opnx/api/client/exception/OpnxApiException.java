package com.opnx.api.client.exception;

/**
 * An exception which can occur while invoking methods of the Opnx API.
 */
public class OpnxApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Opnx API.
     */
    private OpnxApiError error;



    /**
     * Instantiates a new opnx api exception.
     *
     * @param error an error response object
     */
    public OpnxApiException(OpnxApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new opnx api exception.
     */
    public OpnxApiException() {
        super();
    }

    /**
     * Instantiates a new opnx api exception.
     *
     * @param message the message
     */
    public OpnxApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new opnx api exception.
     *
     * @param cause the cause
     */
    public OpnxApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new opnx api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public OpnxApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Opnx API, or null if no response object was returned (e.g. server returned 500).
     */
    public OpnxApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.toString();
        }
        return super.getMessage();
    }
}
