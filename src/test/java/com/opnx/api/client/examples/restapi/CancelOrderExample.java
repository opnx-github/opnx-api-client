package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.order.BatchOrderRequest;
import com.opnx.api.client.domain.order.OrderCancelV3Resp;
import com.opnx.api.client.domain.order.OrderRequest;

import java.util.ArrayList;
import java.util.List;


public class CancelOrderExample {

    public static void main(String[] args) {
        BatchOrderRequest batchOrderRequest = new BatchOrderRequest();
        batchOrderRequest.setRecvWindow(20000);
        batchOrderRequest.setResponseType("FULL");
        batchOrderRequest.setTimestamp(System.currentTimeMillis());
        List<OrderRequest> orderRequestList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setMarketCode("BTC-USDT-SWAP-LIN");
        orderRequest.setOrderId(1000079235084L);
        orderRequestList.add(orderRequest);
        batchOrderRequest.setOrders(orderRequestList);

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestClient client = factory.newRestClient();

        OpnxV3RestResponse<List<OrderCancelV3Resp>> cancelAccountOrder = client.cancelAccountOrder(batchOrderRequest);
        System.out.println(JSONObject.toJSONString(cancelAccountOrder));
    }
}
