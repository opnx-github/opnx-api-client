package com.opnx.api.client.impl;

import com.opnx.api.client.OpnxRestApiCallback;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.exception.OpnxApiError;
import com.opnx.api.client.exception.OpnxApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

import static com.opnx.api.client.impl.OpnxApiServiceGenerator.getOpnxApiError;

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a OpnxApiCallback which is exposed to the client.
 */
public class OpnxApiCallbackAdapter<T> implements Callback<T> {

    private final OpnxRestApiCallback<T> callback;

    public OpnxApiCallbackAdapter(OpnxRestApiCallback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        OpnxV3RestResponse externalV3RestResponse = (OpnxV3RestResponse) response.body();
        if (response.isSuccessful() && externalV3RestResponse.isSuccess()) {
            callback.onResponse(response.body());
        } else {
            if (response.code() == 504) {
                // HTTP 504 return code is used when the API successfully sent the message but not get a response within the timeout period.
                // It is important to NOT treat this as a failure; the execution status is UNKNOWN and could have been a success.
                return;
            }
            try {
                OpnxApiError apiError = getOpnxApiError(response);
                throw new OpnxApiException(apiError);
            } catch (IOException e) {
                throw new OpnxApiException(e.getMessage());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
    }
}
