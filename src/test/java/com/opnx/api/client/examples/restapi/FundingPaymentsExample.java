package com.opnx.api.client.examples.restapi;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.funding.FundingPaymentsV3Resp;

import java.util.List;

public class FundingPaymentsExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<FundingPaymentsV3Resp>> fundingRates = client.getAccountFundingPayments("BTC-USDT-SWAP-LIN", 10L, null, null);
        System.out.println(JSONObject.toJSONString(fundingRates));
    }
}
