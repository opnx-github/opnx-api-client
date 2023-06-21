package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.CallbackAndEvent;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.OrderType;
import com.opnx.api.client.domain.event.*;
import com.opnx.api.client.domain.messages.*;
import com.opnx.api.client.enums.TimeInForce;
import com.opnx.api.client.impl.MultipleCallbacksWebSocketListener;
import com.opnx.api.client.security.SignatureUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.opnx.api.client.constant.WebSocketCMDConstants.PLACE_ORDER_MSG;
import static com.opnx.api.client.constant.WebSocketCMDConstants.SUBSCRIBE_ALL_ORDER_MSG;

public class OrderSubscribeWebSocketLoginExample {
    private static volatile boolean isLogin = false;
    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        LoginCommand loginMessage = getLoginCMD();
        String subscribeMessage = getSubscribeCMD();
        String positionCMD = getSubscribePositionCMD();
        String balanceCMD = getSubscribeBalanceCMD();

        Map<String, CallbackAndEvent> callbackAndEventMap = new HashMap<>();

        CallbackAndEvent<BalanceEvent> balanceCallbackAndEvent = new CallbackAndEvent();
        balanceCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof BalanceEvent){
                System.out.println();
                System.out.println("balance ..." + result.toString());
                System.out.println("balance ..." + result.getAccountId());
                System.out.println();
            }
        });
        balanceCallbackAndEvent.setEventClass(BalanceEvent.class, callbackAndEventMap);

        CallbackAndEvent<PositionEvent> positionCallbackAndEvent = new CallbackAndEvent();
        positionCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof PositionEvent){
                System.out.println();
                System.out.println("position ..." + result.toString());
                System.out.println("position ..." + result.getAccountId());
                System.out.println();
            }
        });
        positionCallbackAndEvent.setEventClass(PositionEvent.class, callbackAndEventMap);

        CallbackAndEvent<SubscribeOrderEvent> orderCallbackAndEvent = new CallbackAndEvent();
        orderCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof SubscribeOrderEvent){
                System.out.println();
                System.out.println("order ..." + result.toString());
                System.out.println("order ..." + result.getTable());
                System.out.println();
            }
        });
        orderCallbackAndEvent.setEventClass(SubscribeOrderEvent.class, callbackAndEventMap);

        CallbackAndEvent<LoginEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof LoginEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();

                isLogin = true;
                if(isLogin){
                    webSocketClient.onOrderUpdateEvent(listenerParam,subscribeMessage);

                    webSocketClient.onPositionUpdateEvent(listenerParam,positionCMD);

                    webSocketClient.onBalanceUpdateEvent(listenerParam,balanceCMD);

                    //String command = getLimitOrderCMD("BTC-USDT-REPO-LIN", 1, BigDecimal.ONE, OrderSide.BUY.name());
                    //listenerParam.send(command);
                }
            }
        });
        loginCallbackAndEvent.setEventClass(LoginEvent.class, callbackAndEventMap);

        MultipleCallbacksWebSocketListener loginListener = new MultipleCallbacksWebSocketListener(callbackAndEventMap,loginMessage.toString());
        webSocketClient.createNewWebSocket(loginListener);

        long sleep = 1000*60*60*24;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public static String getSubscribeBalanceCMD(){
        List<String> args = new ArrayList<>();
        args.add(WebSocketCMDConstants.SUBSCRIBE_BALANCE_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

    public static String getSubscribePositionCMD(){
        List<String> args = new ArrayList<>();
        args.add(WebSocketCMDConstants.SUBSCRIBE_POSITION_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

    public static String getSubscribeCMD(){
        List<String> args = new ArrayList<>();
        args.add(SUBSCRIBE_ALL_ORDER_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

    public static LoginCommand getLoginCMD(){
        String timestamp = String.valueOf(LocalDateTime.now(ZoneId.of("UTC")).toInstant(ZoneOffset.UTC).toEpochMilli());
        String method = "GET";
        String requestPath = "/auth/self/verify";
        String newSign = SignatureUtil.createHmacSha256Sign(timestamp+method+requestPath, "GBPHDNij/0f6Sqh5SE5YBgc/rB+1h0B18/H3lQfSsIk=");

        LoginCommandData loginCommandData = new LoginCommandData();
        loginCommandData.setApiKey("D+5Jaf27TbTIWNUVe7JFKhZ8PuC9RF3fR/H1jL/9AfU=");
        loginCommandData.setTimestamp(timestamp);
        loginCommandData.setSignature(newSign);

        LoginCommand loginCommand = new LoginCommand();
        loginCommand.setOp(WebSocketCMDConstants.LOGIN_MSG);
        loginCommand.setTag("login");
        loginCommand.setData(loginCommandData);
        return loginCommand;
    }


    public static String getLimitOrderCMD(String marketCode, long clientOrderId, BigDecimal quantity, String side) {
        String timestamp = String.valueOf(LocalDateTime.now(ZoneId.of("UTC")).toInstant(ZoneOffset.UTC).toEpochMilli());
        PlaceorderCommandData placeorderCommandData = new PlaceorderCommandData();
        placeorderCommandData.setTimestamp(timestamp);
        placeorderCommandData.setRecvWindow("5000");
        placeorderCommandData.setClientOrderId(String.valueOf(clientOrderId));
        placeorderCommandData.setMarketCode(marketCode);
        placeorderCommandData.setSide(side);
        placeorderCommandData.setOrderType(OrderType.LIMIT.name());
        placeorderCommandData.setQuantity(quantity.toPlainString());
        placeorderCommandData.setTimeInForce(TimeInForce.GTC.name());
        placeorderCommandData.setPrice("-0.0001");
        PlaceorderCommand placeorderCommand = new PlaceorderCommand();
        placeorderCommand.setOp(PLACE_ORDER_MSG);
        placeorderCommand.setTag("tag");
        placeorderCommand.setData(placeorderCommandData);
        return JSON.toJSONString(placeorderCommand);
    }
}
