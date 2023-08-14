package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.ticker.TickerV3Resp;

import java.util.List;


public class TickersExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getTickersByMarketCode("BTC-oUSD-SWAP-LIN", response -> System.out.println(JSONObject.toJSONString(response)));
    }

}
