package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.order.BatchOrderRequest;
import com.opnx.api.client.domain.order.OrderRequest;

import java.util.ArrayList;
import java.util.List;


public class CancelOrderExampleAsync {

    public static void main(String[] args) {
        BatchOrderRequest batchOrderRequest = new BatchOrderRequest();
        batchOrderRequest.setRecvWindow(20000);
        batchOrderRequest.setResponseType("FULL");
        batchOrderRequest.setTimestamp(System.currentTimeMillis());
        List<OrderRequest> orderRequestList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMarketCode("BTC-oUSD-SWAP-LIN");
        orderRequest.setOrderId(1000079235084L);
        orderRequestList.add(orderRequest);
        batchOrderRequest.setOrders(orderRequestList);

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.cancelAccountOrder(batchOrderRequest,
                response -> System.out.println(JSONObject.toJSONString(response)));
    }
}
