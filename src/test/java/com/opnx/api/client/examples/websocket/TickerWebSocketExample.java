package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.event.TickerEvent;
import com.opnx.api.client.domain.messages.SubscribeCommand;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TickerWebSocketExample {
    private static Logger logger = Logger.getLogger(TickerWebSocketExample.class.getName());
    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        String subscribeMessage = getSubscribeCMD();

        OpnxApiWebSocketListener<TickerEvent> listener = new OpnxApiWebSocketListener<>((result,listenerParam) -> {
            if(result != null){
                System.out.println("result ..."+ result.toString());
            }
        }, TickerEvent.class,subscribeMessage);

        webSocketClient.onTickerUpdateEvent(listener);

        System.out.println("websocket send msg: "+subscribeMessage);

        long sleep = 1000*60*60*24;
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            logger.error("sleep error: ", e);
        }
    }

    public static String getSubscribeCMD(){
        List<String> args = new ArrayList<>();
        args.add(WebSocketCMDConstants.SUBSCRIBE_TICKER_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

}
