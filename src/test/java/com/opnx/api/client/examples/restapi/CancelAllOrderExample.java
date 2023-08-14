package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.order.*;



public class CancelAllOrderExample {

    public static void main(String[] args) {
        OrderCancelAllParamV3 orderCancelAllParamV3 = new OrderCancelAllParamV3();
        orderCancelAllParamV3.setMarketCode("BTC-oUSD-SWAP-LIN");

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<OrderCancelAllResp> cancelAllAccountOrder = client.cancelAccountAllOrder(orderCancelAllParamV3);
        System.out.println(JSONObject.toJSONString(cancelAllAccountOrder));
    }
}
