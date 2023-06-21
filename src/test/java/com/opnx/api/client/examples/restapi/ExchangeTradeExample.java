package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.PublicTradesV3Resp;

import java.util.List;


public class ExchangeTradeExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<PublicTradesV3Resp>> publicTrades = client.getPublicTrades("BTC-USDT-SWAP-LIN", 6L, null, null);
        System.out.println(JSONObject.toJSONString(publicTrades));
    }
}
