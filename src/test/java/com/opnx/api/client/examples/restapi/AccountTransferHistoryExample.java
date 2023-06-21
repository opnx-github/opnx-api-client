package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.TransferHistoryV3Rsp;

import java.util.List;


public class AccountTransferHistoryExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<TransferHistoryV3Rsp>> transferHistory = client.getTransferHistory("USDT", 10L, null, null);
        System.out.println(JSONObject.toJSONString(transferHistory));
    }
}
