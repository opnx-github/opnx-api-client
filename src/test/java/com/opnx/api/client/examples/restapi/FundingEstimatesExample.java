package com.opnx.api.client.examples.restapi;
import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.funding.FundingEstimateV3Resp;

import java.util.List;

public class FundingEstimatesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<FundingEstimateV3Resp>> fundingEstimatesByMarketCode = client.getFundingEstimatesByMarketCode("BTC-oUSD-SWAP-LIN");
        System.out.println(JSONObject.toJSONString(fundingEstimatesByMarketCode));
    }
}
