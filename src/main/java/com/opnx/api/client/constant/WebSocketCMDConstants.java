package com.opnx.api.client.constant;


public class WebSocketCMDConstants {

    public static final String LOGIN_MSG = "login";
    public static final String PLACE_ORDER_MSG =  "placeorder";
    public static final String MODIFY_ORDER_MSG = "modifyorder";
    public static final String CANCEL_ORDER_MSG = "cancelorder";
    public static final String SUBSCRIBE_ALL_ORDER_MSG = "order:all";
    public static final String SUBSCRIBE_BEST_BID_ASK_MSG = "bestBidAsk:MY_MARKET_CODE";
    public static final String INCREMENTAL_ORDER_BOOK_MSG = "depthUpdate:MY_MARKET_CODE";
    public static final String SUBSCRIBE_TICKER_MSG = "ticker:all";
    public static final String SUBSCRIBE_POSITION_MSG = "position:all";
    public static final String SUBSCRIBE_BALANCE_MSG = "balance:all";
    public static final String SUBSCRIBE_DEPTH_MSG = "depth:MY_MARKET_CODE";
    public static final String SUBSCRIBE_TRADE_MSG = "trade:MY_MARKET_CODE";
    public static final String SUBSCRIBE_CANDLES60S_MSG = "candles60s:MY_MARKET_CODE";
    public static final String SUBSCRIBE_MARKET_ALL_MSG = "market:all";
    public static final String SUBSCRIBE_LIQUIDATION_RFQ_MSG = "liquidationRFQ";
}
