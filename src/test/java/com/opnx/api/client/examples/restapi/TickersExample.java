package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.ticker.TickerV3Resp;

import java.util.List;


public class TickersExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<TickerV3Resp>> tickersByMarketCode = client.getTickersByMarketCode("BTC-USDT-SWAP-LIN");
        System.out.println(JSONObject.toJSONString(tickersByMarketCode));
    }

}
