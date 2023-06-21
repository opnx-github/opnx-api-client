package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.event.*;
import com.opnx.api.client.domain.messages.SubscribeCommand;
import com.opnx.api.client.enums.TimeInForce;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;
import com.opnx.api.client.security.SignatureUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class BestBidAskWebSocketExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        String subscribeMessage = getSubscribeCMD();

        OpnxApiWebSocketListener<BestBidAskEvent> listener = new OpnxApiWebSocketListener<>((result,listenerParam) -> {
            if(result != null){
                System.out.println("result ..."+ result.toString());
            }
        }, BestBidAskEvent.class,subscribeMessage);

        //webSocketClient.createNewWebSocket(listener);
        webSocketClient.onBestBidAskUpdateEvent(listener);
        System.out.println("websocket send msg: "+subscribeMessage);

        long sleep = 1000*60*60*24;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getSubscribeCMD(){
        List<String> args = new ArrayList<>();
        args.add(WebSocketCMDConstants.SUBSCRIBE_BEST_BID_ASK_MSG
                .replace("MY_MARKET_CODE", "BTC-USDT-REPO-LIN"));
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

}
