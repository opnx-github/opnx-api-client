package com.opnx.api.client.security;

import com.google.common.collect.Maps;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SignatureUtil {
    public static final String SIGN_METHOD = "HmacSHA256";
    public static final String RETURN_SIGN = "\n";
    public static final String EQUAL_SIGN = "=";
    public static final String AND_SIGN = "&";
    public static final String UTF_8 = "UTF-8";

    public static String createSignature(String signKey, String timestamp, String nonce,
                                         String httpMethod, String host, String path,
                                         Map<String, List> queryParams, String requestBody) {
        StringBuilder toSign = new StringBuilder();
        toSign.append(timestamp).append(RETURN_SIGN);
        toSign.append(nonce).append(RETURN_SIGN);
        toSign.append(httpMethod).append(RETURN_SIGN);
        toSign.append(host.toLowerCase()).append(RETURN_SIGN);
        toSign.append(path).append(RETURN_SIGN);

        if (queryParams != null && queryParams.size() > 0) {
            sortByKey(queryParams, false);
            toSign.append(createSignString(queryParams));
        }
        toSign.append(Optional.ofNullable(requestBody).orElse(""));
        return createHmacSha256Sign(toSign.toString(), signKey);
    }


    public static Mac MAC;

    static {
        try {
            MAC = Mac.getInstance(SIGN_METHOD);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeErrorException(new Error("Can't get Mac's instance."));
        }
    }

    public static String createHmacSha256Sign(String message, String secretKey) {
        try {
            byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, SIGN_METHOD);
            Mac mac = (Mac) MAC.clone();
            mac.init(secretKeySpec);
            return Base64.getEncoder().encodeToString(mac.doFinal(message.getBytes()));
        } catch (InvalidKeyException | CloneNotSupportedException e) {
            return null;
        }
    }

    private static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    private static String createSignString(Map<String, List> sortedParams) {
        StringBuilder toSign = new StringBuilder();
        sortedParams.forEach((k, v) -> {
            if (v != null && v.size() > 0) {
                List valueList = v;
                String encodedValue = (String) valueList.get(0);
                try {
                    encodedValue = URLEncoder.encode(encodedValue, UTF_8);
                } catch (UnsupportedEncodingException e) {
                }
                toSign.append(k).append(EQUAL_SIGN).append(encodedValue).append(AND_SIGN);
            }
        });
        if (toSign.length() > 0) {
            return toSign.substring(0, toSign.length() - 1);
        }
        return toSign.toString();
    }

}
