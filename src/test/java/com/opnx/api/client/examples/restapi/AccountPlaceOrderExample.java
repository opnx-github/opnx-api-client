package com.opnx.api.client.examples.restapi;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.order.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class AccountPlaceOrderExample {

    public static void main(String[] args) {
        BatchOrderRequest batchOrderRequest = new BatchOrderRequest();
        batchOrderRequest.setRecvWindow(20000);
        batchOrderRequest.setResponseType("FULL");
        batchOrderRequest.setTimestamp(System.currentTimeMillis());
        List<OrderRequest> orderRequestList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setClientOrderId(System.currentTimeMillis());
        orderRequest.setMarketCode("BCH-USDTT-SWAP-LIN");
        orderRequest.setSide("BUY");
        orderRequest.setQuantity(new BigDecimal("0.11"));
        orderRequest.setTimeInForce("GTC");
        orderRequest.setOrderType("LIMIT");
        orderRequest.setPrice(new BigDecimal("131.26"));
        orderRequestList.add(orderRequest);
        batchOrderRequest.setOrders(orderRequestList);

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET,  System.currentTimeMillis()+"", null, true, true);
        OpnxApiRestClient client = factory.newRestClientWithNonceAndTimestamp();

        OpnxV3RestResponse<List<OrderPlaceRespV3>> accountPlaceOrder = client.accountPlaceOrder(batchOrderRequest);
        System.out.println(JSONObject.toJSONString(accountPlaceOrder));
    }
}
