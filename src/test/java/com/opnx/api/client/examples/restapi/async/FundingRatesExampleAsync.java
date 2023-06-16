package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.FundingRatesV3Resp;

import java.util.List;


public class FundingRatesExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getFundingRates("BTC-USDT-SWAP-LIN", 6L, null, null,
                response -> System.out.println(JSONObject.toJSONString(response)));
    }

}
