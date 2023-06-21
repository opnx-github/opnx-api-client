package com.opnx.api.client.security;

import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.constant.OpnxApiConstants;
import com.opnx.api.client.utils.DateTimeUtil;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.*;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final String secret;

    private String nonce;

    private String timestamp;

    public AuthenticationInterceptor(String apiKey, String secret, String nonce, String timestamp) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.nonce = nonce;
        this.timestamp = timestamp;
    }

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();
        boolean isSignatureRequired = original.header(OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED) != null;
        newRequestBuilder.removeHeader(OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED);
        // Endpoint requires sending a valid API-KEY
        if (isSignatureRequired) {
            String method = original.method();
            HttpUrl url = original.url();
            String host = OpnxApiConfig.useTestNet ? OpnxApiConfig.TESTNET_DOMAIN : OpnxApiConfig.BASE_DOMAIN;
            newRequestBuilder.addHeader(OpnxApiConstants.API_KEY_HEADER, apiKey);
            String newTimestamp = StringUtils.isNotBlank(this.timestamp) ? this.timestamp : DateTimeUtil.getFormatTimestamp();
            String newNonce = StringUtils.isNotBlank(nonce) ? nonce : System.currentTimeMillis() + "";
            newRequestBuilder.addHeader(OpnxApiConstants.TIMESTAMP, newTimestamp);
            newRequestBuilder.addHeader(OpnxApiConstants.NONCE, newNonce);
            String pathUlr = getPathUrl(url.pathSegments());
            RequestBody requestBody = original.body();
            String requestBodyString = bodyToString(requestBody);
            Map<String, List> queryParams = getQueryParams(url);
            String signature = SignatureUtil.createSignature(secret, newTimestamp, newNonce, method, host, pathUlr, queryParams.size() == 0 ? null : queryParams, requestBodyString);
            newRequestBuilder.addHeader(OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED, signature);
        }
        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String bodyToString(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            final RequestBody copy = request;
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, secret);
    }


    public Map<String, List> getQueryParams(HttpUrl url) {
        Map<String, List> queryParams = new LinkedHashMap<>();
        for (String queryParamsName : url.queryParameterNames()) {
            queryParams.put(queryParamsName, Arrays.asList(url.queryParameter(queryParamsName)));
        }
        return queryParams;
    }

    public String getPathUrl(List<String> pathSegments) {
        return "/" + StringUtils.join(pathSegments.toArray(), "/");
    }

}