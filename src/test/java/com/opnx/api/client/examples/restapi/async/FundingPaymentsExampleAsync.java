package com.opnx.api.client.examples.restapi.async;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.funding.FundingPaymentsV3Resp;

import java.util.List;

public class FundingPaymentsExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getAccountFundingPayments("BTC-oUSD-SWAP-LIN", 10L, 0L, null,
                response -> System.out.println(JSONObject.toJSONString(response)));


    }
}
