package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.MarketsV3Resp;

import java.util.List;


public class MarketsExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<MarketsV3Resp>> marketsByMarketCode = client.getMarketsByMarketCode("BTC-USDT-SWAP-LIN");
        System.out.println(JSONObject.toJSONString(marketsByMarketCode));
    }

}
