package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.config.OpnxApiConfig;

import java.util.Arrays;


public class AccountInfoExampleAsync {

    public static void main(String[] args) {
        //OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET,false,false);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getAccountInfo(Arrays.asList("13670979-1621913298587", "PERMISSIONLESS_165"),
                response -> System.out.println(JSONObject.toJSONString(response)));

    }
}
