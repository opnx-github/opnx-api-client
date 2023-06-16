package com.opnx.api.client.impl;

import com.opnx.api.client.OpnxApiRestAsyncClient;
import com.opnx.api.client.OpnxApiService;
import com.opnx.api.client.OpnxRestApiCallback;
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

import static com.opnx.api.client.impl.OpnxApiServiceGenerator.createService;

/**
 * Implementation of Opnx's REST API using Retrofit with asynchronous/non-blocking method calls.
 */

public class OpnxApiAsyncRestClientImpl implements OpnxApiRestAsyncClient {

    private final OpnxApiService opnxApiService;

    public OpnxApiAsyncRestClientImpl(String apiKey, String secret) {
        opnxApiService = createService(OpnxApiService.class, apiKey, secret);
    }

    public OpnxApiAsyncRestClientImpl(String apiKey, String secret, String nonce, String timestamp) {
        opnxApiService = createService(OpnxApiService.class, apiKey, secret, nonce, timestamp);
    }

    @Override
    public void getTickersByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<TickerV3Resp>>> callback) {
        opnxApiService.getTickersByMarketCode(marketCode).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketsByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<MarketsV3Resp>>> callback) {
        opnxApiService.getMarketsByMarketCode(marketCode).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetsByAsset(String asset, OpnxRestApiCallback<OpnxV3RestResponse<List<AssetsV3Resp>>> callback) {
        opnxApiService.getAssetsByAsset(asset).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFundingEstimatesByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingEstimateV3Resp>>> callback) {
        opnxApiService.getFundingEstimatesByMarketCode(marketCode).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCandles(String marketCode, String timeframe, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<CandlesV3Resp>>> callback) {
        opnxApiService.getCandles(marketCode, timeframe, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDepths(String marketCode, Long level, OpnxRestApiCallback<OpnxV3RestResponse<DepthV3Resp>> callback) {
        opnxApiService.getDepths(marketCode, level).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPublicTrades(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<PublicTradesV3Resp>>> callback) {
        opnxApiService.getPublicTrades(marketCode, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFundingRates(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingRatesV3Resp>>> callback) {
        opnxApiService.getFundingRates(marketCode, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountTrades(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<TradesV3Resp>>> callback) {
        opnxApiService.getAccountTrades(marketCode, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubAccounts(OpnxRestApiCallback<OpnxV3RestResponse<List<SubAccountInfoV3Resp>>> callback) {
        opnxApiService.getSubAccounts().enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountFundingPayments(String marketCode, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<FundingPaymentsV3Resp>>> callback) {
        opnxApiService.getAccountFundingPayments(marketCode, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenOrders(String marketCode, Long orderId, Long clientOrderId, OpnxRestApiCallback<OpnxV3RestResponse<List<WorkingOrderV3Resp>>> callback) {
        opnxApiService.getOpenOrders(marketCode, orderId, clientOrderId).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOrdersStatus(Long orderId, Long clientOrderId, OpnxRestApiCallback<OpnxV3RestResponse<OrderHistoryV3Resp>> callback) {
        opnxApiService.getOrdersStatus(orderId, clientOrderId).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountInfo(List<String> subAcc, OpnxRestApiCallback<OpnxV3RestResponse<List<AccountInfoV3Resp>>> callback) {
        opnxApiService.getAccountInfo(subAcc).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountBalance(List<String> subAcc, String asset, OpnxRestApiCallback<OpnxV3RestResponse<List<BalanceV3Resp>>> callback) {
        opnxApiService.getAccountBalance(subAcc, asset).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountPositions(List<String> subAcc, String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<PositionsV3Resp>>> callback) {
        opnxApiService.getAccountPositions(subAcc, marketCode).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void accountTransfer(TransferV3Param transferParam, OpnxRestApiCallback<OpnxV3RestResponse<TransferV3Resp>> callback) {
        opnxApiService.accountTransfer(transferParam).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransferHistory(String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<TransferHistoryV3Rsp>>> callback) {
        opnxApiService.getTransferHistory(asset, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDepositAddresses(String asset, String network, OpnxRestApiCallback<OpnxV3RestResponse<DepositAddressV3Resp>> callback) {
        opnxApiService.getDepositAddresses(asset, network).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDepositHistory(String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<DepositHistoryV3Resp>>> callback) {
        opnxApiService.getDepositHistory(asset, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void accountWithdrawal(WithdrawV3Params withdrawV3Params, OpnxRestApiCallback<OpnxV3RestResponse<WithdrawV3Resp>> callback) {
        opnxApiService.accountWithdrawal(withdrawV3Params).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getWithdrawalHistory(String id, String asset, Long limit, Long startTime, Long endTime, OpnxRestApiCallback<OpnxV3RestResponse<List<WithdrawHistoryV3Resp>>> callback) {
        opnxApiService.getWithdrawalHistory(id, asset, limit, startTime, endTime).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAccountOrder(BatchOrderRequest batchOrderRequest, OpnxRestApiCallback<OpnxV3RestResponse<List<OrderCancelV3Resp>>> callback) {
        opnxApiService.cancelAccountOrder(batchOrderRequest).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAccountAllOrder(OrderCancelAllParamV3 orderCancelAllParamV3, OpnxRestApiCallback<OpnxV3RestResponse<OrderCancelAllResp>> callback) {
        opnxApiService.cancelAccountAllOrder(orderCancelAllParamV3).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void accountPlaceOrder(BatchOrderRequest batchOrderRequest, OpnxRestApiCallback<OpnxV3RestResponse<List<OrderPlaceRespV3>>> callback) {
        opnxApiService.accountPlaceOrder(batchOrderRequest).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLeverageTiersByMarketCode(String marketCode, OpnxRestApiCallback<OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>>> callback) {
        opnxApiService.getLeverageTiersByMarketCode(marketCode).enqueue(new OpnxApiCallbackAdapter<>(callback));
    }

}
