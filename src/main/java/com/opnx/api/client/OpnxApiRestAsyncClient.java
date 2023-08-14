package com.opnx.api.client;

import com.opnx.api.client.domain.OpnxV3RestResponse;
import com.opnx.api.client.domain.account.*;
import com.opnx.api.client.domain.asset.AssetsV3Resp;
import com.opnx.api.client.domain.candles.CandlesV3Resp;
import com.opnx.api.client.domain.depth.DepthV3Resp;
import com.opnx.api.client.domain.funding.FundingEstimateV3Resp;
import com.opnx.api.client.domain.funding.FundingPaymentsV3Resp;
import com.opnx.api.client.domain.order.*;
import com.opnx.api.client.domain.ticker.TickerV3Resp;
import com.opnx.api.client.domain.trade.*;
import retrofit2.http.Query;

import java.util.List;

/**
 * Opnx API facade, supporting asynchronous/non-blocking access Opnx's REST API.
 */
public interface OpnxApiRestAsyncClient {

    /**
     * Get tickers. (asynchronous).
     *
     * @param marketCode Market code
     * @param callback   the callback that handles the response
     */
    void getTickersByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<TickerV3Resp>>> callback);

    /**
     * Get a list of markets on Opnx. (asynchronous).
     *
     * @param marketCode Market code
     * @param callback   the callback that handles the response
     */
    void getMarketsByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<MarketsV3Resp>>> callback);

    /**
     * Get a list of assets supported on Opnx (asynchronous).
     *
     * @param asset    Asset name
     * @param callback the callback that handles the response
     */
    void getAssetsByAsset(String asset, OpnxRestApiCallback<OpnxV3RestResponse<List<AssetsV3Resp>>> callback);

    /**
     * Get funding estimates (asynchronous).
     *
     * @param marketCode Market code
     * @param callback   the callback that handles the response
     */
    void getFundingEstimatesByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingEstimateV3Resp>>> callback);

    /**
     * Get candles. (asynchronous).
     *
     * @param marketCode Market code
     * @param timeframe  Available values: 60s,300s,900s,1800s,3600s,7200s,14400s,86400s, default is 3600s
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other.
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other.
     * @param callback   the callback that handles the response
     */
    void getCandles(String marketCode, String timeframe, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<CandlesV3Resp>>> callback);

    /**
     * Get depth. (asynchronous).
     *
     * @param marketCode Market code
     * @param level      Default 5, max 100
     * @param callback   the callback that handles the response
     */
    void getDepths(String marketCode, Long level, OpnxRestApiCallback<OpnxV3RestResponse<DepthV3Resp>> callback);

    /**
     * Get public trade (asynchronous).
     *
     * @param marketCode Market code
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback   the callback that handles the response
     */
    void getPublicTrades(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<PublicTradesV3Resp>>> callback);

    /**
     * Get all historical financing rates (asynchronous).
     *
     * @param marketCode Market code
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback   the callback that handles the response
     */
    void getFundingRates(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingRatesV3Resp>>> callback);

    /**
     * Returns the most recent trades of the account connected to the API key initiating the request. (asynchronous).
     *
     * @param marketCode Market code
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback   the callback that handles the response
     */
    void getAccountTrades(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<TradesV3Resp>>> callback);

    /**
     * This endpoint can only be called using API keys paired with the parent account! Returns all active subaccounts. (asynchronous).
     *
     * @param callback the callback that handles the response
     */
    void getSubAccounts(OpnxRestApiCallback<OpnxV3RestResponse<List<SubAccountInfoV3Resp>>> callback);

    /**
     * Get funding payments by marketCode and sorted by time in descending order. (asynchronous).
     *
     * @param marketCode Market code e.g. BTC-USDT-REPO-LIN
     * @param limit      default is 200, max is 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback   the callback that handles the response
     */
    void getAccountFundingPayments(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingPaymentsV3Resp>>> callback);

    /**
     * Returns all the open orders of the account connected to the API key initiating the request. (asynchronous).
     *
     * @param marketCode    Market code,default most recent orders first
     * @param orderId       Client assigned ID to help manage and identify orders
     * @param clientOrderId Client assigned ID to help manage and identify orders with max value 9223372036854775807
     * @param callback      the callback that handles the response
     */
    void getOpenOrders(String marketCode, Long orderId, Long clientOrderId, OpnxRestApiCallback<OpnxV3RestResponse<List<WorkingOrderV3Resp>>> callback);

    /**
     * et latest order status (asynchronous).
     *
     * @param orderId       Order ID
     * @param clientOrderId Client assigned ID to help manage and identify orders with max value 9223372036854775807
     * @param callback      the callback that handles the response
     */
    void getOrdersStatus(Long orderId, Long clientOrderId, OpnxRestApiCallback<OpnxV3RestResponse<OrderHistoryV3Resp>> callback);

    /**
     * Get account information (asynchronous).
     *
     * @param subAcc   Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @param callback the callback that handles the response
     */
    void getAccountInfo(List<String> subAcc, OpnxRestApiCallback<OpnxV3RestResponse<List<AccountInfoV3Resp>>> callback);

    /**
     * Calling this endpoint using an API key pair linked to the parent account with the parameter "subAcc" allows the caller to include additional sub-accounts in the response. This feature does not work when using API key pairs linked to a sub-account. (asynchronous).
     *
     * @param subAcc   Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @param asset    Default all assets
     * @param callback the callback that handles the response
     */
    void getAccountBalance(List<String> subAcc, String asset, OpnxRestApiCallback<OpnxV3RestResponse<List<BalanceV3Resp>>> callback);

    /**
     * Get account position (asynchronous).
     *
     * @param subAcc     Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @param marketCode Market code,Default all markets
     * @param callback   the callback that handles the response
     */
    void getAccountPositions(List<String> subAcc, String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<PositionsV3Resp>>> callback);

    /**
     * Account balance transfer (asynchronous).
     *
     * @param transferParam Transfer request parameters
     * @param callback      the callback that handles the response
     */
    void accountTransfer(TransferV3Param transferParam, OpnxRestApiCallback<OpnxV3RestResponse<TransferV3Resp>> callback);

    /**
     * Get account balance transfer history (asynchronous).
     *
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback  the callback that handles the response
     */
    void getTransferHistory(String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<TransferHistoryV3Rsp>>> callback);

    /**
     * Get Deposit addresses (asynchronous).
     *
     * @param asset    Asset name
     * @param network  Asset network
     * @param callback the callback that handles the response
     */
    void getDepositAddresses(String asset, String network, OpnxRestApiCallback<OpnxV3RestResponse<DepositAddressV3Resp>> callback);

    /**
     * Get Deposit history (asynchronous).
     *
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @param callback  the callback that handles the response
     */
    void getDepositHistory(String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<DepositHistoryV3Resp>>> callback);

    /**
     * Withdrawal request (asynchronous).
     *
     * @param withdrawV3Params Withdrawal request parameters
     * @param callback         the callback that handles the response
     */
    void accountWithdrawal(WithdrawV3Params withdrawV3Params, OpnxRestApiCallback<OpnxV3RestResponse<WithdrawV3Resp>> callback);

    /**
     * Withdrawal history (asynchronous).
     *
     * @param id        id
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other. This filter applies to "requestedAt"
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other. This filter applies to "completedAt"
     * @param callback  the callback that handles the response
     */
    void getWithdrawalHistory(String id, String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<WithdrawHistoryV3Resp>>> callback);

    /**
     * Cancels all open orders for the **specified market** for the account connected to the API key initiating the request. (asynchronous).
     *
     * @param batchOrderRequest Cancel order request parameters
     * @param callback          the callback that handles the response
     */
    void cancelAccountOrder(BatchOrderRequest batchOrderRequest, OpnxRestApiCallback<OpnxV3RestResponse<List<OrderCancelV3Resp>>> callback);

    /**
     * Cancels all open orders for the **specified market** for the account connected to the API key initiating the request. (asynchronous).
     *
     * @param orderCancelAllParamV3 Cancel order request parameters
     * @param callback              the callback that handles the response
     */
    void cancelAccountAllOrder(OrderCancelAllParamV3 orderCancelAllParamV3, OpnxRestApiCallback<OpnxV3RestResponse<OrderCancelAllResp>> callback);

    /**
     * Place orders. (asynchronous).
     *
     * @param batchOrderRequest Place order request parameters
     * @param callback          the callback that handles the response
     */
    void accountPlaceOrder(BatchOrderRequest batchOrderRequest, OpnxRestApiCallback<OpnxV3RestResponse<List<OrderPlaceRespV3>>> callback);


    /**
     * Get leverage tiers (asynchronous).
     *
     * @param marketCode Market code
     * @param callback   the callback that handles the response
     */
    void getLeverageTiersByMarketCode(@Query("marketCode") String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>>> callback);

}
