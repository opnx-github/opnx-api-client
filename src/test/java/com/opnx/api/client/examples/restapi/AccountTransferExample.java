package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.TransferV3Param;
import com.opnx.api.client.domain.account.TransferV3Resp;

import java.math.BigDecimal;


public class AccountTransferExample {

    public static void main(String[] args) {
        TransferV3Param transferV3Param = new TransferV3Param();
        transferV3Param.setAsset("USDT");
        transferV3Param.setQuantity(new BigDecimal("1"));
        transferV3Param.setFromAccount(165L);
        transferV3Param.setToAccount(200000000030L);

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<TransferV3Resp> accountTransfer = client.accountTransfer(transferV3Param);
        System.out.println(JSONObject.toJSONString(accountTransfer));
    }
}
