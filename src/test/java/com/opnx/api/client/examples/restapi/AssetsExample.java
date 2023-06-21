package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.asset.AssetsV3Resp;

import java.util.List;

public class AssetsExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<AssetsV3Resp>> externalV3RestResponse = client.getAssetsByAsset("BTC");
        System.out.println(JSONObject.toJSONString(externalV3RestResponse));

    }
}
