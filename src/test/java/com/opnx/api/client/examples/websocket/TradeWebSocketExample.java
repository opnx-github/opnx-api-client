package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.event.DepthEvent;
import com.opnx.api.client.domain.event.TradeEvent;
import com.opnx.api.client.domain.messages.SubscribeCommand;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;

import java.util.ArrayList;
import java.util.List;

public class TradeWebSocketExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        String subscribeMessage = getSubscribeCMD("BTC-USDT-SWAP-LIN");

        OpnxApiWebSocketListener<TradeEvent> listener = new OpnxApiWebSocketListener<>((result,listenerParam) -> {
            if(result != null){
                System.out.println("result ..."+ result.toString());
                System.out.println("result ..."+ result.getTable());
            }
        }, TradeEvent.class,subscribeMessage);

        webSocketClient.onTradeUpdateEvent(listener);

        System.out.println("websocket send msg: "+subscribeMessage);

        long sleep = 1000*60*60*24;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String getSubscribeCMD(String marketCode){
        List<String> args = new ArrayList<>();
        args.add(WebSocketCMDConstants.SUBSCRIBE_TRADE_MSG
                         .replace("MY_MARKET_CODE", marketCode));
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

}
