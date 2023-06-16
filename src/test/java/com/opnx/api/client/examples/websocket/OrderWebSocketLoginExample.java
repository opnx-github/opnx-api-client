package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opnx.api.client.CallbackAndEvent;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.OrderSide;
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
import java.util.HashMap;
import java.util.Map;

import static com.opnx.api.client.constant.WebSocketCMDConstants.*;

public class OrderWebSocketLoginExample {
    private static volatile boolean isLogin = false;
    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        //String loginMessage = getLoginCMD().toString();
        String loginMessage = JSON.toJSONString(getLoginCMD());

        String limitOrderCMD = getLimitOrderCMD("BTC-USDT-REPO-LIN", 1, BigDecimal.ONE, OrderSide.BUY.name());
        String marketOrderCMD = getMarketOrderCMD("BTC-USDT-REPO-LIN", 1, BigDecimal.ONE, OrderSide.BUY.name());
        String stopLimitOrderCMD = getStopLimitOrderCMD("BTC-USDT-REPO-LIN", 1, BigDecimal.ONE, OrderSide.BUY.name());
        String timestamp = String.valueOf(LocalDateTime.now(ZoneId.of("UTC")).toInstant(ZoneOffset.UTC).toEpochMilli());

        ModifyorderCommandData commandData = new ModifyorderCommandData();
        commandData.setTimestamp(timestamp);
        commandData.setRecvWindow("5000");
        commandData.setOrderId("1000712236933");
        commandData.setMarketCode("BTC-USDT-REPO-LIN");
        commandData.setSide(OrderSide.SELL.name());
        commandData.setQuantity("1");
        commandData.setPrice("0");
        ModifyorderCommand command = new ModifyorderCommand();
        command.setOp(MODIFY_ORDER_MSG);
        command.setTag("tag");
        command.setData(commandData);
        String modifyOrderCommand = JSON.toJSONString(command);

        CancelorderCommandData cancelorderCommandData = new CancelorderCommandData();
        cancelorderCommandData.setMarketCode("BTC-USDT-REPO-LIN");
        cancelorderCommandData.setOrderId("1000712236933");
        CancelorderCommand cancelorderCommand = new CancelorderCommand();
        cancelorderCommand.setOp(CANCEL_ORDER_MSG);
        cancelorderCommand.setTag("tag");
        cancelorderCommand.setData(cancelorderCommandData);


        Map<String, CallbackAndEvent> callbackAndEventMap = new HashMap<>();

        ping(callbackAndEventMap);
        placeLimitOrder(callbackAndEventMap);
        placeMarketOrder(callbackAndEventMap);
        placeStopLimitOrder(callbackAndEventMap);
        placeModifyOrder(callbackAndEventMap);
        placeCancelOrder(callbackAndEventMap);

        CallbackAndEvent<LoginEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof LoginEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();

                isLogin = true;
                if(isLogin){
                    try {
                        listenerParam.send(limitOrderCMD);
                        Thread.sleep(1000);
                        listenerParam.send(marketOrderCMD);
                        Thread.sleep(1000);
                        listenerParam.send(stopLimitOrderCMD);
                        Thread.sleep(1000);
                        listenerParam.send(modifyOrderCommand);
                        Thread.sleep(1000);
                        listenerParam.send(JSON.toJSONString(cancelorderCommand));
                        new Thread(() -> {
                            while (true) {
                                listenerParam.send("ping");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        loginCallbackAndEvent.setEventClass(LoginEvent.class,callbackAndEventMap);

        MultipleCallbacksWebSocketListener loginListener = new MultipleCallbacksWebSocketListener(callbackAndEventMap,loginMessage);
        webSocketClient.createNewWebSocket(loginListener);

        long sleep = 1000*60*60*24;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void ping(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<PingEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof PingEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(PingEvent.class,callbackAndEventMap);
    }

    public static void placeLimitOrder(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<PlaceOrderEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof PlaceOrderEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(PlaceOrderEvent.class,callbackAndEventMap);
    }
    public static void placeMarketOrder(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<PlaceOrderEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof PlaceOrderEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(PlaceOrderEvent.class,callbackAndEventMap);
    }
    public static void placeStopLimitOrder(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<PlaceOrderEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof PlaceOrderEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(PlaceOrderEvent.class,callbackAndEventMap);
    }
    public static void placeModifyOrder(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<ModifyOrderEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof ModifyOrderEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(ModifyOrderEvent.class,callbackAndEventMap);
    }
    public static void placeCancelOrder(Map<String, CallbackAndEvent> callbackAndEventMap){
        CallbackAndEvent<CancelOrderEvent> loginCallbackAndEvent = new CallbackAndEvent();
        loginCallbackAndEvent.setCallback((result,listenerParam) -> {
            if(result != null && result instanceof CancelOrderEvent){
                System.out.println();
                System.out.println("result ..." + result.toString());
                System.out.println("result ..." + result.getEvent());
                System.out.println();
            }
        });
        loginCallbackAndEvent.setEventClass(CancelOrderEvent.class,callbackAndEventMap);
    }

    public static String getMarketOrderCMD(String marketCode, long clientOrderId, BigDecimal quantity, String side) {
        String timestamp = String.valueOf(LocalDateTime.now(ZoneId.of("UTC")).toInstant(ZoneOffset.UTC).toEpochMilli());
        PlaceorderCommandData placeorderCommandData = new PlaceorderCommandData();
        placeorderCommandData.setTimestamp(timestamp);
        placeorderCommandData.setRecvWindow("5000");
        placeorderCommandData.setClientOrderId(String.valueOf(clientOrderId));
        placeorderCommandData.setMarketCode(marketCode);
        placeorderCommandData.setSide(side);
        placeorderCommandData.setOrderType(OrderType.MARKET.name());
        placeorderCommandData.setQuantity(quantity.toPlainString());
        //placeorderCommandData.setTimeInForce(TimeInForce.GTC.name());
        //placeorderCommandData.setPrice("-0.0001");
        PlaceorderCommand placeorderCommand = new PlaceorderCommand();
        placeorderCommand.setOp(PLACE_ORDER_MSG);
        placeorderCommand.setTag("tag");
        placeorderCommand.setData(placeorderCommandData);
        return JSON.toJSONString(placeorderCommand);
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

    public static String getStopLimitOrderCMD(String marketCode, long clientOrderId, BigDecimal quantity, String side) {
        String timestamp = String.valueOf(LocalDateTime.now(ZoneId.of("UTC")).toInstant(ZoneOffset.UTC).toEpochMilli());

        PlaceorderCommandData placeorderCommandData = new PlaceorderCommandData();
        placeorderCommandData.setTimestamp(timestamp);
        placeorderCommandData.setRecvWindow("5000");
        placeorderCommandData.setClientOrderId(String.valueOf(clientOrderId));
        placeorderCommandData.setMarketCode(marketCode);
        placeorderCommandData.setSide(side);
        placeorderCommandData.setOrderType(OrderType.STOP.name());
        placeorderCommandData.setQuantity(quantity.toPlainString());
        placeorderCommandData.setTimeInForce(TimeInForce.MAKER_ONLY_REPRICE.name());
        placeorderCommandData.setStopPrice("-0.0001");
        placeorderCommandData.setLimitPrice("-0.0001");

        PlaceorderCommand placeorderCommand = new PlaceorderCommand();
        placeorderCommand.setOp(PLACE_ORDER_MSG);
        placeorderCommand.setTag("tag");
        placeorderCommand.setData(placeorderCommandData);
        return JSON.toJSONString(placeorderCommand);
    }
}
