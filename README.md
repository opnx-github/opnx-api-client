# Java Opnx API

opnx-api-client is a lightweight Java library , providing complete API coverage, and supporting synchronous and asynchronous requests, as well as event streaming using WebSockets.

## Features
* Support for synchronous and asynchronous REST requests to all stream endpoints.
* Support for User Data, Trade, and Depth event streaming 

## Installation
1. Install library into your Maven's local repository by running `mvn install`
2. Add the following Maven dependency to your project's `pom.xml`:
```
    <dependency>
      <groupId>com.opnx.api</groupId>
      <artifactId>opnx-api-client</artifactId>
      <version>1.0.0</version>
    </dependency>
```

Alternatively, you can clone this repository and run the examples 

## Examples

### Getting Started

There are three main client classes that can be used to interact with the API:

1. `OpnxApiRestClient`  a synchronous/blocking Opnx API client;
2. `OpnxApiAsyncRestClient` an asynchronous/non-blocking Opnx API client;
3. `OpnxApiWebSocketClient`  a data streaming client using Opnx WebSocket API.

These can be instantiated through the corresponding factory method of `OpnxApiClientFactory`.
When the parameter is true, the test is used, and the parameter is false, which is the live environment.
```java
 OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance("API_KEY", "API_KEY_SECRET",true,true);
 OpnxApiRestClient client = factory.newRestClient();
```

Users can only pass their own Api Key and Secret to access the live environment
```java
 OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance("API_KEY", "API_KEY_SECRET");
 OpnxApiRestClient client = factory.newRestClient();
```

If the client only needs to access endpoints which do not require additional security, then these parameters are optional.

Once the client is instantiated, it is possible to start making requests to the API.


#### GET /v3/account
```java
OpnxV3RestResponse<List<AccountInfoV3Resp>> accountInfo = client.getAccountInfo(Arrays.asList("13670979-1621913298587", "PERMISSIONLESS_165"));
System.out.println(JSONObject.toJSONString(accountInfo));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "success": true,
    "data": [
        {
            "accountId": "21213",
            "name": "main",
            "accountType": "LINEAR",
            "balances": [
                {
                    "asset": "BTC",
                    "total": "2.823",
                    "available": "2.823",
                    "reserved": "0",
                    "lastUpdatedAt": "1593627415234"
                },
                {
                    "asset": "FLEX",
                    "total": "1585.890",
                    "available": "325.890",
                    "reserved": "1260",
                    "lastUpdatedAt": "1593627415123"
                }
            ],
            "positions": [
                {
                    "marketCode": "FLEX-USDT-SWAP-PER", 
                    "baseAsset": "FLEX", 
                    "counterAsset": "USDT", 
                    "position": "11411.1", 
                    "entryPrice": "3.590", 
                    "markPrice": "6.360", 
                    "positionPnl": "31608.7470", 
                    "estLiquidationPrice": "2.59", 
                    "lastUpdatedAt": "1637876701404",
                    "marginBalance": "45264.03",
                    "maintenanceMargin": "10886.1894",
                    "marginRatio": "0.24",
                    "leverage": "3"
                }
            ],
            "collateral": "1231231",
            "notionalPositionSize": "50000.0",
            "portfolioVarMargin": "500",
            "riskRatio": "20000.0000",
            "maintenanceMargin": "1231",
            "marginRatio": "12.3179",
            "liquidating": false,
            "feeTier": "6",
            "createdAt": "1611665624601"
        }
    ]
}
```
</details>

#### GET /v3/account/names
```java
OpnxV3RestResponse<List<SubAccountInfoV3Resp>> subAccounts = client.getSubAccounts();
System.out.println(JSONObject.toJSONString(subAccounts));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "success": true,
    "data":  [  {
                    "accountId": "21213",
                    "name": "Test 1"
                }, 
                {
                    "accountId": "21214",
                    "name": "Test 2"
              }
          ] 
}
```
</details>


#### GET /v3/positions
```java
OpnxV3RestResponse<List<PositionsV3Resp>> accountPositions = client.getAccountPositions(Arrays.asList("13670979-1621913298587", "test_opnx_api"), "BTC-USDT-SWAP-LIN");
System.out.println(JSONObject.toJSONString(accountPositions));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "data": [
        {
            "accountId": "165",
            "name": "main",
            "positions": [
                {
                    "baseAsset": "BTC",
                    "counterAsset": "USDT",
                    "entryPrice": "22938.97488422",
                    "estLiquidationPrice": "12208536.690",
                    "lastUpdatedAt": "1677024022627",
                    "markPrice": "23571.790",
                    "marketCode": "BTC-USDT-SWAP-LIN",
                    "position": "-1.795000000",
                    "positionPnl": "-1135.90313282510000000"
                }
            ]
        }
    ],
    "success": true
}
```
</details>


#### GET /v3/exchange-trades
```java
 OpnxV3RestResponse<List<PublicTradesV3Resp>> publicTrades = client.getPublicTrades("BTC-USDT-SWAP-LIN", 6L, null, null);
 System.out.println(JSONObject.toJSONString(publicTrades));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "success": true,
    "data": [
        {
            "marketCode": "BTC-USDT-SWAP-LIN",
            "matchPrice": "9600.00000" ,
            "matchQuantity": "0.100000" ,
            "side": "BUY" ,
            "matchType": "TAKER" ,
            "matchedAt": "1662207330439" 
        }
    ]
}
```
</details>


#### GET /v3/candles
```java
OpnxV3RestResponse<List<CandlesV3Resp>> candles = client.getCandles("BTC-USDT-SWAP-LIN", "60s", 10L, null, null);
System.out.println(JSONObject.toJSONString(candles));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "data": [
        {
            "close": "23565.09200000",
            "currencyVolume": "0",
            "high": "23566.45300000",
            "low": "23563.03600000",
            "open": "23563.50900000",
            "openedAt": "1677486180000",
            "volume": "0"
        },
        {
            "close": "23563.40800000",
            "currencyVolume": "0",
            "high": "23568.46400000",
            "low": "23561.99400000",
            "open": "23568.46400000",
            "openedAt": "1677486120000",
            "volume": "0"
        },
        {
            "close": "23568.88200000",
            "currencyVolume": "0",
            "high": "23573.66000000",
            "low": "23568.88200000",
            "open": "23570.14800000",
            "openedAt": "1677486060000",
            "volume": "0"
        },
        {
            "close": "23570.20300000",
            "currencyVolume": "0",
            "high": "23574.24700000",
            "low": "23570.20300000",
            "open": "23572.48200000",
            "openedAt": "1677486000000",
            "volume": "0"
        }
    ],
    "success": true,
    "timeframe": "60s"
}
```
</details>


### Asynchronous requests
To make an asynchronous request it is necessary to use the OpnxApiAsyncRestClient, and call the method with the same name as in the synchronous version, but passing a callback OpnxApiCallback that handles the response whenever it arrives.

#### GET /v3/trades
```java
 client.getPublicTrades("FlEX-USDT", 6L, null, null,response -> System.out.println(JSONObject.toJSONString(response)));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "success": true,
    "data": [
                {
                    "orderId": "160067484555913076",
                    "clientOrderId": "123",
                    "matchId": "160067484555913077",
                    "marketCode": "FLEX-USDT",
                    "side": "SELL",
                    "matchedQuantity": "0.1",
                    "matchPrice": "0.065",
                    "total": "0.0065",  
                    "leg1Price'": "0.0065",         
                    "leg2Price": "0.0065",          
                    "orderMatchType": "TAKER",
                    "feeAsset": "FLEX",
                    "fee":"0.0096",
                    "source": "10",
                    "matchedAt": "1595514663626"

               }
            ]
}
```
</details>


#### GET /v3/markets
```java
 client.getMarketsByMarketCode("BTC-USDT-SWAP-LIN", response -> System.out.println(JSONObject.toJSONString(response)));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "data": [
        {
            "base": "BTC",
            "counter": "USDT",
            "indexPrice": "23385.460",
            "lastUpdatedAt": "1677485772175",
            "listedAt": "1608621449015",
            "lowerPriceBound": "11784.567",
            "markPrice": "23569.135",
            "marketCode": "BTC-USDT-SWAP-LIN",
            "minSize": "0.001",
            "name": "BTC/USDT Perp",
            "referencePair": "BTC/USDT",
            "tickSize": "0.001",
            "type": "FUTURE",
            "upperPriceBound": "35078.190"
        }
    ],
    "success": true
}
```
</details>


#### GET /v3/tickers
```java
 client.getTickersByMarketCode("BTC-USDT-SWAP-LIN", response -> System.out.println(JSONObject.toJSONString(response)));
```
<details>
 <summary>View Response</summary>
 
```java
{
    "data": [
        {
            "currencyVolume24h": "0",
            "high24h": "23680.460",
            "lastTradedPrice": "23644.95",
            "lastTradedQuantity": "0.001",
            "lastUpdatedAt": "1677485905039",
            "low24h": "23140.760",
            "markPrice": "23569.916",
            "marketCode": "BTC-USDT-SWAP-LIN",
            "open24h": "23160.130",
            "openInterest": "0",
            "volume24h": "0"
        }
    ],
    "success": true
}
```
</details>


### WebSocket Requests
There are two main ways to use it, one is to use the command without logging in, and the other is to use the command after logging in.

#### Login-free subscription depth
```java
    OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
    OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();
    String subscribeMessage = getSubscribeDepthCMD("BTC-USDT-REPO-LIN");
    OpnxApiWebSocketListener<DepthEvent> listener = new OpnxApiWebSocketListener<>((result,listenerParam) -> {
        if(result != null){
            System.out.println("result ..."+ result.toString());
        }
    }, DepthEvent.class,subscribeMessage);
    webSocketClient.onDepthUpdateEvent(listener);
    System.out.println("websocket send msg: "+subscribeMessage);
```
<details>
 <summary>View Response</summary>

```java
{
    "table": "depth",
    "data": {
        "seqNum": 2166539633781384,
        "asks": [
            [
                19024.0,
                1.0
            ],
            [
                19205.0,
                4.207
            ],
            [
                19395.0,
                8.414
            ]
        ],
        "bids": [
            [
                18986.0,
                1.0
            ],
            [
                18824.0,
                4.207
            ],
            [
                18634.0,
                8.414
            ]
        ],
        "checksum": 3475315026,
        "marketCode": "BTC-USDT-SWAP-LIN",
        "timestamp": 1665454814328
    },
    "action": "partial"
}
```
</details>


#### Login to place an order
##### Multiple callbacks can be placed in callbackAndEventMap to handle the responses of different events. It should be noted that when the same event is placed, the callbacks placed later will overwrite the callbacks placed earlier, so that the callbacks placed first will not is called.
##### You need to place an order in the login callback method body, because you need to log in to place an order
```java
    OpnxApiClientFactory factory = OpnxApiClientFactory.newInstance(true,true);
    OpnxApiWebSocketClient webSocketClient = factory.newWebSocketClient();
    String loginMessage = JSON.toJSONString(getLoginCMD());
    String limitOrderCMD = getLimitOrderCMD("BTC-USDT-REPO-LIN", 1, BigDecimal.ONE, OrderSide.BUY.name());
    Map<String, CallbackAndEvent> callbackAndEventMap = new HashMap<>();
    placeLimitOrder(callbackAndEventMap);
    CallbackAndEvent<LoginEvent> loginCallbackAndEvent = new CallbackAndEvent();
    loginCallbackAndEvent.setCallback((result,listenerParam) -> {
        if(result != null && result instanceof LoginEvent){
            System.out.println();
            System.out.println("result ..." + result.toString());
            System.out.println("result ..." + result.getEvent());
            System.out.println();
            isLogin = true;
            if(isLogin){
                listenerParam.send(limitOrderCMD);
            }
        }
    });
    loginCallbackAndEvent.setEventClass(LoginEvent.class,callbackAndEventMap);

    MultipleCallbacksWebSocketListener loginListener = new MultipleCallbacksWebSocketListener(callbackAndEventMap,loginMessage);
    webSocketClient.createNewWebSocket(loginListener);
```
<details>
 <summary>View Response</summary>

```java
{
  "event": "placeorder",
  "submitted": True,
  "tag": "123",
  "timestamp": "1592491945248",
  "data": {
            "clientOrderId": 1,
            "marketCode": "BTC-USDT-SWAP-LIN",
            "side": "BUY",
            "orderType": "LIMIT",
            "quantity": "1.5",
            "timeInForce": "GTC",
            "orderId": "1000000700008",
            "price": "9431.48",
            "source": 0
          }
}
```
</details>

### More examples
An extensive set of examples, covering most aspects of the API, can be found at https://github.com/opnx-github/opnx-api-client/tree/master/src/test/java/com/opnx/api/client/examples

