package com.opnx.api.client.examples.restapi.async;

import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.config.OpnxApiConfig;
import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.order.BatchOrderRequest;
import com.opnx.api.client.domain.order.OrderPlaceRespV3;
import com.opnx.api.client.domain.order.OrderRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class AccountPlaceOrderExampleAsync {

    public static void main(String[] args) {

        /**
         * {
         *     "recvWindow": 20000,
         *     "responseType": "FULL",
         *     "timestamp": 1615430912440,
         *     "orders": [
         *              {
         *                    "clientOrderId": 1612249737724,
         *                    "marketCode": "BTC-oUSD-SWAP-LIN",
         *                    "side": "SELL",
         *                    "quantity": "0.001",
         *                    "timeInForce": "GTC",
         *                    "orderType": "LIMIT",
         *                    "price": "50007"
         *                },
         *                {
         *                    "clientOrderId": 1612249737724,
         *                    "marketCode": "BTC-oUSD-SWAP-LIN",
         *                    "side": "BUY",
         *                    "quantity": "0.002",
         *                    "timeInForce": "GTC",
         *                    "orderType": "LIMIT",
         *                    "price": "54900"
         *                }
         *     ]
         * }
         */

        BatchOrderRequest batchOrderRequest = new BatchOrderRequest();
        batchOrderRequest.setRecvWindow(20000);
        batchOrderRequest.setResponseType("FULL");
        batchOrderRequest.setTimestamp(System.currentTimeMillis());
        List<OrderRequest> orderRequestList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setClientOrderId(System.currentTimeMillis());
        orderRequest.setMarketCode("BTC-oUSD-SWAP-LIN");
        orderRequest.setSide("BUY");
        orderRequest.setQuantity(new BigDecimal("0.001"));
        orderRequest.setTimeInForce("GTC");
        orderRequest.setOrderType("LIMIT");
        orderRequest.setPrice(new BigDecimal("23644.95"));

        orderRequestList.add(orderRequest);
        batchOrderRequest.setOrders(orderRequestList);

        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(OpnxApiConfig.API_KEY, OpnxApiConfig.API_KEY_SECRET);
        OpnxApiRestAsyncClient client = factory.newAsyncRestClient();

        client.accountPlaceOrder(batchOrderRequest, response -> System.out.println(JSONObject.toJSONString(response)));

    }
}
