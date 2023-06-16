package com.opnx.api.client.impl;

import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.exception.OpnxApiError;
import com.opnx.api.client.exception.OpnxApiException;
import com.opnx.api.client.security.AuthenticationInterceptor;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Generates a Opnx API implementation based on @see {@link com.opnx.api.client.OpnxApiService}.
 */
public class OpnxApiServiceGenerator {
    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(26, TimeUnit.SECONDS)
                .build();
    }

    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, OpnxApiError> errorBodyConverter =
            (Converter<ResponseBody, OpnxApiError>) converterFactory.responseBodyConverter(
                    OpnxApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    /**
     * Create a Opnx API service.
     *
     * @param serviceClass the type of service.
     * @param apiKey       opnx API key.
     * @param secret       opnx secret.
     * @return a new implementation of the API endpoints for the Opnx API service.
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {
        String baseUrl = null;
        if (OpnxApiConfig.useTestNet) {
            baseUrl = OpnxApiConfig.getTestNetBaseUrl();
        } else {
            baseUrl = OpnxApiConfig.getApiBaseUrl();
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }


    /**
     * Create a Opnx API service.
     *
     * @param serviceClass the type of service.
     * @param apiKey       opnx API key.
     * @param secret       opnx secret.
     * @param nonce        nonce value eg: "123"
     * @param timestamp    timestamp eg: "2023-02-24T07:13:00"
     * @return a new implementation of the API endpoints for the Opnx API service.
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret, String nonce, String timestamp) {
        String baseUrl = null;
        if (OpnxApiConfig.useTestNet) {
            baseUrl = OpnxApiConfig.getTestNetBaseUrl();
        } else {
            baseUrl = OpnxApiConfig.getApiBaseUrl();
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret, nonce, timestamp);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            OpnxV3RestResponse externalV3RestResponse = (OpnxV3RestResponse) response.body();
            if (response.isSuccessful() && externalV3RestResponse.isSuccess()) {
                return response.body();
            } else {
                OpnxApiError apiError = getOpnxApiError(response);
                throw new OpnxApiException(apiError);
            }
        } catch (IOException e) {
            throw new OpnxApiException(e.getMessage());
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static OpnxApiError getOpnxApiError(Response<?> response) throws IOException, OpnxApiException {
        if (response.code() == 401) {
            return new OpnxApiError(response.isSuccessful(), response.code() + "", response.message());
        }
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
