package com.opnx.api.client.examples.restapi;


import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.DepositAddressV3Resp;


public class DepositAddressesExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<DepositAddressV3Resp> depositAddresses = client.getDepositAddresses("USDT", "0xD25bCD2DBb6114d3BB29CE946a6356B49911358e");
        System.out.println(JSONObject.toJSONString(depositAddresses));

    }

}
