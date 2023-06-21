package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.depth.DepthV3Resp;


public class DepthsExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<DepthV3Resp> depths = client.getDepths("BTC-USDT-REPO-LIN", 5L);
        System.out.println(JSONObject.toJSONString(depths));

    }

}
