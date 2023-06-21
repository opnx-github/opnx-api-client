package com.opnx.api.client.examples.restapi;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.WithdrawHistoryV3Resp;

import java.util.List;


public class WithdrawalHistoryExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<WithdrawHistoryV3Resp>> withdrawalHistory = client.getWithdrawalHistory("ex", "USDT", 1l, null, null);
        System.out.println(JSONObject.toJSONString(withdrawalHistory));
    }

}
