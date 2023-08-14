package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.order.OrderCancelAllParamV3;


public class CancelAllOrderExampleAsync {

    public static void main(String[] args) {
        OrderCancelAllParamV3 orderCancelAllParamV3 = new OrderCancelAllParamV3();
        orderCancelAllParamV3.setMarketCode("BTC-oUSD-SWAP-LIN");

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.cancelAccountAllOrder(orderCancelAllParamV3,
                response -> System.out.println(JSONObject.toJSONString(response)));
    }
}
