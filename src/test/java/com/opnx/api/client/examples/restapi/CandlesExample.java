package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.candles.CandlesV3Resp;

import java.util.List;


public class CandlesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<CandlesV3Resp>> candles = client.getCandles("BTC-USDT-SWAP-LIN", "60s", 10L, null, null);
        System.out.println(JSONObject.toJSONString(candles));

    }

}
