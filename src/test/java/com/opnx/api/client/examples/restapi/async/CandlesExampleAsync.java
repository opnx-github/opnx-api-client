package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.candles.CandlesV3Resp;

import java.util.List;


public class CandlesExampleAsync {

    public static void main(String[] args) {
        //OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(null,null,false);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getCandles("BTC-USDT-SWAP-LIN", "60s", 10L, null, null,
                response -> System.out.println(JSONObject.toJSONString(response)));

    }

}
