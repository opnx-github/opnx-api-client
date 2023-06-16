package com.opnx.api.client.impl;

import com.opnx.api.client.OpnxApiRestClient;
import com.opnx.api.client.OpnxApiService;
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
import static com.opnx.api.client.impl.OpnxApiServiceGenerator.executeSync;

/**
 * Implementation of Opnx's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class OpnxApiRestClientImpl implements OpnxApiRestClient {

    private final OpnxApiService opnxApiService;

    public OpnxApiRestClientImpl(String apiKey, String secret) {
        opnxApiService = createService(OpnxApiService.class, apiKey, secret);
    }

    public OpnxApiRestClientImpl(String apiKey, String secret,String nonce,String timestamp) {
        opnxApiService = createService(OpnxApiService.class, apiKey, secret, nonce, timestamp);
    }

    @Override
    public OpnxV3RestResponse<List<TickerV3Resp>> getTickersByMarketCode(String marketCode) {
        return executeSync(opnxApiService.getTickersByMarketCode(marketCode));

    }

    @Override
    public OpnxV3RestResponse<List<MarketsV3Resp>> getMarketsByMarketCode(String marketCode) {
        return executeSync(opnxApiService.getMarketsByMarketCode(marketCode));
    }

    @Override
    public OpnxV3RestResponse<List<AssetsV3Resp>> getAssetsByAsset(String asset) {
        return executeSync(opnxApiService.getAssetsByAsset(asset));
    }

    @Override
    public OpnxV3RestResponse<List<FundingEstimateV3Resp>> getFundingEstimatesByMarketCode(String marketCode) {
        return executeSync(opnxApiService.getFundingEstimatesByMarketCode(marketCode));
    }

    @Override
    public OpnxV3RestResponse<List<CandlesV3Resp>> getCandles(String marketCode, String timeframe, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getCandles(marketCode, timeframe, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<DepthV3Resp> getDepths(String marketCode, Long level) {
        return executeSync(opnxApiService.getDepths(marketCode, level));
    }

    @Override
    public OpnxV3RestResponse<List<PublicTradesV3Resp>> getPublicTrades(String marketCode, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getPublicTrades(marketCode, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<List<FundingRatesV3Resp>> getFundingRates(String marketCode, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getFundingRates(marketCode, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<List<TradesV3Resp>> getAccountTrades(String marketCode, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getAccountTrades(marketCode, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<List<SubAccountInfoV3Resp>> getSubAccounts() {
        return executeSync(opnxApiService.getSubAccounts());
    }

    @Override
    public OpnxV3RestResponse<List<FundingPaymentsV3Resp>> getAccountFundingPayments(String marketCode, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getAccountFundingPayments(marketCode, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<List<WorkingOrderV3Resp>> getOpenOrders(String marketCode, Long orderId, Long clientOrderId) {
        return executeSync(opnxApiService.getOpenOrders(marketCode, orderId, clientOrderId));
    }

    @Override
    public OpnxV3RestResponse<OrderHistoryV3Resp> getOrdersStatus(Long orderId, Long clientOrderId) {
        return executeSync(opnxApiService.getOrdersStatus(orderId, clientOrderId));
    }

    @Override
    public OpnxV3RestResponse<List<AccountInfoV3Resp>> getAccountInfo(List<String> subAcc) {
        return executeSync(opnxApiService.getAccountInfo(subAcc));
    }

    @Override
    public OpnxV3RestResponse<List<BalanceV3Resp>> getAccountBalance(List<String> subAcc, String asset) {
        return executeSync(opnxApiService.getAccountBalance(subAcc, asset));
    }

    @Override
    public OpnxV3RestResponse<List<PositionsV3Resp>> getAccountPositions(List<String> subAcc, String marketCode) {
        return executeSync(opnxApiService.getAccountPositions(subAcc, marketCode));
    }

    @Override
    public OpnxV3RestResponse<TransferV3Resp> accountTransfer(TransferV3Param transferParam) {
        return executeSync(opnxApiService.accountTransfer(transferParam));
    }

    @Override
    public OpnxV3RestResponse<List<TransferHistoryV3Rsp>> getTransferHistory(String asset, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getTransferHistory(asset, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<DepositAddressV3Resp> getDepositAddresses(String asset, String network) {
        return executeSync(opnxApiService.getDepositAddresses(asset, network));
    }

    @Override
    public OpnxV3RestResponse<List<DepositHistoryV3Resp>> getDepositHistory(String asset, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getDepositHistory(asset, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<WithdrawV3Resp> accountWithdrawal(WithdrawV3Params withdrawV3Params) {
        return executeSync(opnxApiService.accountWithdrawal(withdrawV3Params));
    }

    @Override
    public OpnxV3RestResponse<List<WithdrawHistoryV3Resp>> getWithdrawalHistory(String id, String asset, Long limit, Long startTime, Long endTime) {
        return executeSync(opnxApiService.getWithdrawalHistory(id, asset, limit, startTime, endTime));
    }

    @Override
    public OpnxV3RestResponse<List<OrderCancelV3Resp>> cancelAccountOrder(BatchOrderRequest batchOrderRequest) {
        return executeSync(opnxApiService.cancelAccountOrder(batchOrderRequest));
    }

    @Override
    public OpnxV3RestResponse<OrderCancelAllResp> cancelAccountAllOrder(OrderCancelAllParamV3 orderCancelAllParamV3) {
        return executeSync(opnxApiService.cancelAccountAllOrder(orderCancelAllParamV3));
    }

    @Override
    public OpnxV3RestResponse<List<OrderPlaceRespV3>> accountPlaceOrder(BatchOrderRequest batchOrderRequest) {
        return executeSync(opnxApiService.accountPlaceOrder(batchOrderRequest));
    }

    @Override
    public OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>> getLeverageTiersByMarketCode(String marketCode) {
        return executeSync(opnxApiService.getLeverageTiersByMarketCode(marketCode));
    }

}
