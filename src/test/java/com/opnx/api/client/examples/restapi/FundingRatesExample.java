package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.FundingRatesV3Resp;

import java.util.List;


public class FundingRatesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<FundingRatesV3Resp>> fundingRates = client.getFundingRates("BTC-oUSD-SWAP-LIN", 6L, null, null);
        System.out.println(JSONObject.toJSONString(fundingRates));
    }

}
