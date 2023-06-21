package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.constant.OpnxApiConstants;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.BalanceV3Resp;
import com.opnx.api.client.utils.DateTimeUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class AccountBalancesExampleAsync {

    public static void main(String[] args) {
        //OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET, "test", DateTimeUtil.getFormatTimestamp());
        OpnxApiRestAsyncClient client = factory.newAsyncRestClientWithNonceAndTimestamp();
        //OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        //OpnxV3RestResponse<List<BalanceV3Resp>> accountInfo = client.getAccountBalance(Arrays.asList("13670979-1621913298587", "PERMISSIONLESS_165"), "SMZ");
        //OpnxV3RestResponse<List<BalanceV3Resp>> accountInfo = client.getAccountBalance(Arrays.asList("test_opnx_api"), "USDT");

        client.getAccountBalance(Arrays.asList("test_opnx_api"), "USDT",
                response -> System.out.println(JSONObject.toJSONString(response)));

    }
}
