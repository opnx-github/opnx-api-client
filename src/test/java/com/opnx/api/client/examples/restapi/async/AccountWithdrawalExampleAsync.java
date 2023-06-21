package com.opnx.api.client.examples.restapi.async;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.WithdrawV3Params;
import com.opnx.api.client.domain.account.WithdrawV3Resp;

import java.math.BigDecimal;


public class AccountWithdrawalExampleAsync {

    public static void main(String[] args) {

        /**
         * {
         *     "asset": "flexUSDT",
         *     "network": "SLP",
         *     "address": "simpleledger:qzlg6uvceehgzgtz6phmvy8gtdqyt6vf35fxqwx3p7",
         *     "quantity": "100",
         *     "externalFee": true,
         *     "tfaType": "GOOGLE",
         *     "code": "743249"
         * }
         */

        WithdrawV3Params withdrawV3Params = new WithdrawV3Params();
        withdrawV3Params.setAsset("flexUSDT");
        withdrawV3Params.setNetwork("SLP");
        withdrawV3Params.setAddress("simpleledger:qzlg6uvceehgzgtz6phmvy8gtdqyt6vf35fxqwx3p7");
        withdrawV3Params.setQuantity(new BigDecimal("100"));
        withdrawV3Params.setExternalFee(true);
        withdrawV3Params.setTfaType("GOOGLE");
        withdrawV3Params.setCode("743249");

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.accountWithdrawal(withdrawV3Params,
                response -> System.out.println(JSONObject.toJSONString(response)));

    }

}
