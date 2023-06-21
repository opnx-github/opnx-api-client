package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.google.errorprone.annotations.Var;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.TransferHistoryV3Rsp;

import java.util.List;


public class AccountTransferHistoryExampleAsync {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.getTransferHistory("USDT", 10L, 1l, null,
                response -> System.out.println(JSONObject.toJSONString(response)));
    }
}
