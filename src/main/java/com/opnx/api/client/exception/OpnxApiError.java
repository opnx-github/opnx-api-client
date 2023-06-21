package com.opnx.api.client.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Opnx API error object.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpnxApiError {

    private Boolean success;

    /**
     * Error code.
     */
    private String code;

    /**
     * Error message.
     */
    private String message;

    public OpnxApiError() {
    }

    public OpnxApiError(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("success", success)
                .append("code", code)
                .append("message", message)
                .toString();
    }
}
