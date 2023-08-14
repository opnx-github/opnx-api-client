package com.opnx.api.client.examples.restapi;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.TradesV3Resp;

import java.util.List;

public class AccountTradesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<TradesV3Resp>> accountTrades = client.getAccountTrades("BTC-oUSD-SWAP-LIN", 10L, 1l, null);
        System.out.println(JSONObject.toJSONString(accountTrades));
    }
}
