package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.PositionsV3Resp;

import java.util.Arrays;
import java.util.List;


public class AccountPositionsExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<PositionsV3Resp>> accountPositions = client.getAccountPositions(Arrays.asList("13670979-1621913298587", "test_opnx_api"), "BTC-USDT-SWAP-LIN");
        System.out.println(JSONObject.toJSONString(accountPositions));
    }
}
