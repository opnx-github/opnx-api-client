package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.BalanceV3Resp;

import java.util.Arrays;
import java.util.List;


public class AccountBalancesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        //OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET,false,false);


        OpnxApiRestClient client = factory.newRestClient();
        OpnxV3RestResponse<List<BalanceV3Resp>> accountInfo = client.getAccountBalance(Arrays.asList("test_opnx_api"), "USDT");
        System.out.println(JSONObject.toJSONString(accountInfo));
    }
}
