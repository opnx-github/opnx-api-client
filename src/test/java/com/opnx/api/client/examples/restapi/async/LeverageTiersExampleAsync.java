package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;


public class LeverageTiersExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getLeverageTiersByMarketCode("BTC-oUSD-SWAP-LIN",
                response -> System.out.println(JSONObject.toJSONString(response)));
    }

}
