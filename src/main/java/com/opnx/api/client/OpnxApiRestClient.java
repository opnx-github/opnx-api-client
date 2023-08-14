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

import java.util.List;

/**
 * Opnx API facade, supporting synchronous/blocking access Opnx's REST API.
 */
public interface OpnxApiRestClient {

    /**
     * Get tickers.
     *
     * @param marketCode market code
     * @return OpnxV3RestResponse
     */

    OpnxV3RestResponse<List<TickerV3Resp>> getTickersByMarketCode(String marketCode);

    /**
     * Get a list of markets on Opnx.
     *
     * @param marketCode market code
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<MarketsV3Resp>> getMarketsByMarketCode(String marketCode);


    /**
     * Get a list of assets supported on Opnx
     *
     * @param asset asset
     * @return  OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<AssetsV3Resp>> getAssetsByAsset(String asset);

    /**
     * @param marketCode market code
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<FundingEstimateV3Resp>> getFundingEstimatesByMarketCode(String marketCode);

    /**
     * Get candles.
     *
     * @param marketCode Market name
     * @param timeframe  Available values: 60s,300s,900s,1800s,3600s,7200s,14400s,86400s, default is 3600s
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other.
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other.
     * @return  OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<CandlesV3Resp>> getCandles(String marketCode, String timeframe, Long limit, Long startTime, Long endTime);

    /**
     * Get depth.
     *
     * @param marketCode Market code
     * @param level      Default 5, max 100
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<DepthV3Resp> getDepths(String marketCode, Long level);


    /**
     * get public trade
     *
     * @param marketCode Market code
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<PublicTradesV3Resp>> getPublicTrades(String marketCode, Long limit, Long startTime, Long endTime);


    /**
     * Get all historical financing rates
     *
     * @param marketCode Market code
     * @param limit      Default 200, max 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other.
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other.
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<FundingRatesV3Resp>> getFundingRates(String marketCode, Long limit, Long startTime, Long endTime);

    /**
     * Returns the most recent trades of the account connected to the API key initiating the request.
     *
     * @param marketCode Market code
     * @param limit      max 500, default 200
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<TradesV3Resp>> getAccountTrades(String marketCode, Long limit, Long startTime, Long endTime);


    /**
     * This endpoint can only be called using API keys paired with the parent account! Returns all active subaccounts.
     *
     * @return  OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<SubAccountInfoV3Resp>> getSubAccounts();

    /**
     * Get funding payments by marketCode and sorted by time in descending order.
     *
     * @param marketCode Market code   e.g. BTC-USDT-REPO-LIN
     * @param limit      default is 200, max is 500
     * @param startTime  Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime    Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<FundingPaymentsV3Resp>> getAccountFundingPayments(String marketCode, Long limit, Long startTime, Long endTime);

    /**
     * Returns all the open orders of the account connected to the API key initiating the request.
     *
     * @param marketCode    default most recent orders first
     * @param orderId       Client assigned ID to help manage and identify orders
     * @param clientOrderId Client assigned ID to help manage and identify orders with max value 9223372036854775807
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<WorkingOrderV3Resp>> getOpenOrders(String marketCode, Long orderId, Long clientOrderId);

    /**
     * Get latest order status
     *
     * @param orderId       Order ID
     * @param clientOrderId Client assigned ID to help manage and identify orders with max value 9223372036854775807
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<OrderHistoryV3Resp> getOrdersStatus(Long orderId, Long clientOrderId);

    /**
     * Get account information
     *
     * @param subAcc Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<AccountInfoV3Resp>> getAccountInfo(List<String> subAcc);

    /**
     * Calling this endpoint using an API key pair linked to the parent account with the parameter "subAcc" allows the caller to include additional sub-accounts in the response. This feature does not work when using API key pairs linked to a sub-account.
     *
     * @param subAcc Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @param asset  Default all assets
     * @return  OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<BalanceV3Resp>> getAccountBalance(List<String> subAcc, String asset);

    /**
     * Get account position
     *
     * @param subAcc     Name of sub account. If no subAcc is given, then the response contains only the account linked to the API-Key.
     * @param marketCode Default all markets
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<PositionsV3Resp>> getAccountPositions(List<String> subAcc, String marketCode);

    /**
     * Account balance transfer
     *
     * @param transferParam Transfer request parameters
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<TransferV3Resp> accountTransfer(TransferV3Param transferParam);

    /**
     * Get account balance transfer history
     *
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<TransferHistoryV3Rsp>> getTransferHistory(String asset, Long limit, Long startTime, Long endTime);

    /**
     * Get Deposit addresses
     *
     * @param asset asset
     * @param network network
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<DepositAddressV3Resp> getDepositAddresses(String asset, String network);

    /**
     * Get Deposit history
     *
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<DepositHistoryV3Resp>> getDepositHistory(String asset, Long limit, Long startTime, Long endTime);

    /**
     * Withdrawal request
     * Withdrawals may only be initiated by API keys that are linked to the parent account and have withdrawals enabled. If the wrong 2fa code is provided the endpoint will block for 10 seconds.
     *
     * @param withdrawV3Params Withdrawal request parameters
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<WithdrawV3Resp> accountWithdrawal(WithdrawV3Params withdrawV3Params);

    /**
     * Withdrawal history
     *
     * @param id        id
     * @param asset     Default all assets
     * @param limit     Default 50, max 200
     * @param startTime Millisecond timestamp. Default 24 hours ago. startTime and endTime must be within 7 days of each other. This filter applies to "requestedAt"
     * @param endTime   Millisecond timestamp. Default time now. startTime and endTime must be within 7 days of each other. This filter applies to "completedAt"
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<WithdrawHistoryV3Resp>> getWithdrawalHistory(String id, String asset, Long limit, Long startTime, Long endTime);

    /**
     * Cancels all open orders for the **specified market** for the account connected to the API key initiating the request.
     *
     * @param batchOrderRequest cancel order request parameters
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<OrderCancelV3Resp>> cancelAccountOrder(BatchOrderRequest batchOrderRequest);

    /**
     * Cancels all open orders for the **specified market** for the account connected to the API key initiating the request.
     *
     * @param orderCancelAllParamV3 cancel order request parameters
     * @return  OpnxV3RestResponse
     */
    OpnxV3RestResponse<OrderCancelAllResp> cancelAccountAllOrder(OrderCancelAllParamV3 orderCancelAllParamV3);

    /**
     * Place orders.
     *
     * @param batchOrderRequest place order request parameters
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<OrderPlaceRespV3>> accountPlaceOrder(BatchOrderRequest batchOrderRequest);


    /**
     *
     * @param marketCode market code
     * @return OpnxV3RestResponse
     */
    OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>> getLeverageTiersByMarketCode(String marketCode);
}
