package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.utils.DateTimeUtil;


public class AssetsExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance();
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getAssetsByAsset("BTC",
                response -> System.out.println(JSONObject.toJSONString(response)));


    }
}
