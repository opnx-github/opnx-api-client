package com.opnx.api.client.examples.websocket;

import com.alibaba.fastjson.JSON;
import com.opnx.api.client.OpnxApiClientFactory;
import com.opnx.api.client.OpnxApiWebSocketClient;
import com.opnx.api.client.constant.WebSocketCMDConstants;
import com.opnx.api.client.domain.event.LiquidationRFQEvent;
import com.opnx.api.client.domain.event.MarketEvent;
import com.opnx.api.client.domain.messages.SubscribeCommand;
import com.opnx.api.client.impl.OpnxApiWebSocketListener;

import java.util.ArrayList;
import java.util.List;

import static com.opnx.api.client.constant.WebSocketCMDConstants.SUBSCRIBE_LIQUIDATION_RFQ_MSG;

public class LiquidationRFQWebSocketExample {

    /**
     * {‘table’: ‘liquidationRFQ’, ‘data’: [{‘quantity’: ‘-0.100’, ‘marketCode’: ‘BTC-USDT-SWAP-LIN’, ‘timestamp’: ‘1676625682082’}]}
     * @param args
     */
    public static void main(String[] args) {
        OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
        OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();

        String subscribeMessage = getSubscribeCMD();

        OpnxApiWebSocketListener<LiquidationRFQEvent> listener = new OpnxApiWebSocketListener<>((result, listenerParam) -> {
            if(result != null){
                System.out.println("result ..."+ result.toString());
                System.out.println("result ..."+ result.getTable());
            }
        }, LiquidationRFQEvent.class,subscribeMessage);

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
        args.add(SUBSCRIBE_LIQUIDATION_RFQ_MSG);
        SubscribeCommand subscribeCommand = new SubscribeCommand();
        subscribeCommand.setOp("subscribe");
        subscribeCommand.setArgs(args);
        subscribeCommand.setTag("tag");
        return JSON.toJSONString(subscribeCommand);
    }

}
