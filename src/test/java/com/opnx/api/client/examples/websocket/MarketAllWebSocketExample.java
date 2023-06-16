package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.event.CandlesEvent;
import com.opnx.api.client.domain.event.MarketEvent;
import com.opnx.api.client.domain.messages.SubscribeCommand;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;

import java.util.ArrayList;
import java.util.List;

import static com.opnx.api.client.constant.WebSocketCMDConstants.SUBSCRIBE_MARKET_ALL_MSG;

public class MarketAllWebSocketExample {

    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        String subscribeMessage = getSubscribeCMD();

        OpnxApiWebSocketListener<MarketEvent> listener = new OpnxApiWebSocketListener<>((result, listenerParam) -> {
            if(result != null){
                System.out.println("result ..."+ result.toString());
                System.out.println("result ..."+ result.getTable());
            }
        }, MarketEvent.class,subscribeMessage);

        webSocketClient.onMarketUpdateEvent(listener);

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
        args.add(SUBSCRIBE_MARKET_ALL_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

}
