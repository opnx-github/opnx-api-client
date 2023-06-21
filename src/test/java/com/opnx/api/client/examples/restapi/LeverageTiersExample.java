package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.trade.LeverageTiersInfoV3Resp;

import java.util.List;


public class LeverageTiersExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>> leverageTiersByMarketCode = client.getLeverageTiersByMarketCode("");
        System.out.println(JSONObject.toJSONString(leverageTiersByMarketCode));
    }

}
