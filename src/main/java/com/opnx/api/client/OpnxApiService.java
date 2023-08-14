package com.opnx.api.client;

import com.opnx.api.client.constant.OpnxApiConstants;
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
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Opnx's REST API URL mappings and endpoint security configuration.
 */
public interface OpnxApiService {

    @GET("/v3/tickers")
    Call<OpnxV3RestResponse<List<TickerV3Resp>>> getTickersByMarketCode(@Query("marketCode") String marketCode);

    @GET("/v3/markets")
    Call<OpnxV3RestResponse<List<MarketsV3Resp>>> getMarketsByMarketCode(@Query("marketCode") String marketCode);

    @GET("/v3/assets")
    Call<OpnxV3RestResponse<List<AssetsV3Resp>>> getAssetsByAsset(@Query("asset") String asset);

    @GET("/v3/funding/estimates")
    Call<OpnxV3RestResponse<List<FundingEstimateV3Resp>>> getFundingEstimatesByMarketCode(@Query("marketCode") String marketCode);

    @GET("/v3/candles")
    Call<OpnxV3RestResponse<List<CandlesV3Resp>>> getCandles(@Query("marketCode") String marketCode,
                                                             @Query("timeframe") String timeframe,
                                                             @Query("limit") Long limit,
                                                             @Query("startTime") Long startTime,
                                                             @Query("endTime") Long endTime);

    @GET("/v3/depth")
    Call<OpnxV3RestResponse<DepthV3Resp>> getDepths(@Query("marketCode") String marketCode,
                                                    @Query("level") Long level);

    @GET("/v3/exchange-trades")
    Call<OpnxV3RestResponse<List<PublicTradesV3Resp>>> getPublicTrades(@Query("marketCode") String marketCode,
                                                                       @Query("limit") Long limit,
                                                                       @Query("startTime") Long startTime,
                                                                       @Query("endTime") Long endTime);


    @GET("/v3/funding/rates")
    Call<OpnxV3RestResponse<List<FundingRatesV3Resp>>> getFundingRates(@Query("marketCode") String marketCode,
                                                                       @Query("limit") Long limit,
                                                                       @Query("startTime") Long startTime,
                                                                       @Query("endTime") Long endTime);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/trades")
    Call<OpnxV3RestResponse<List<TradesV3Resp>>> getAccountTrades(@Query("marketCode") String marketCode,
                                                                  @Query("limit") Long limit,
                                                                  @Query("startTime") Long startTime,
                                                                  @Query("endTime") Long endTime);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/funding")
    Call<OpnxV3RestResponse<List<FundingPaymentsV3Resp>>> getAccountFundingPayments(@Query("marketCode") String marketCode,
                                                                                    @Query("limit") Long limit,
                                                                                    @Query("startTime") Long startTime,
                                                                                    @Query("endTime") Long endTime);

    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/orders/working")
    Call<OpnxV3RestResponse<List<WorkingOrderV3Resp>>> getOpenOrders(@Query("marketCode") String marketCode,
                                                                     @Query("orderId") Long orderId,
                                                                     @Query("clientOrderId") Long clientOrderId);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/orders/status")
    Call<OpnxV3RestResponse<OrderHistoryV3Resp>> getOrdersStatus(@Query("orderId") Long orderId, @Query("clientOrderId") Long clientOrderId);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/account/names")
    Call<OpnxV3RestResponse<List<SubAccountInfoV3Resp>>> getSubAccounts();


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/account")
    Call<OpnxV3RestResponse<List<AccountInfoV3Resp>>> getAccountInfo(@Query("subAcc") List<String> subAcc);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/balances")
    Call<OpnxV3RestResponse<List<BalanceV3Resp>>> getAccountBalance(@Query("subAcc") List<String> subAcc, @Query("asset") String asset);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/positions")
    Call<OpnxV3RestResponse<List<PositionsV3Resp>>> getAccountPositions(@Query("subAcc") List<String> subAcc, @Query("marketCode") String marketCode);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/transfer")
    Call<OpnxV3RestResponse<TransferV3Resp>> accountTransfer(@Body TransferV3Param transferParam);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/transfer")
    Call<OpnxV3RestResponse<List<TransferHistoryV3Rsp>>> getTransferHistory(@Query("asset") String asset,
                                                                            @Query("limit") Long limit,
                                                                            @Query("startTime") Long startTime,
                                                                            @Query("endTime") Long endTime);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/deposit-addresses")
    Call<OpnxV3RestResponse<DepositAddressV3Resp>> getDepositAddresses(@Query("asset") String asset, @Query("network") String network);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/deposit")
    Call<OpnxV3RestResponse<List<DepositHistoryV3Resp>>> getDepositHistory(@Query("asset") String asset,
                                                                           @Query("limit") Long limit,
                                                                           @Query("startTime") Long startTime,
                                                                           @Query("endTime") Long endTime);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/withdrawal")
    Call<OpnxV3RestResponse<WithdrawV3Resp>> accountWithdrawal(@Body WithdrawV3Params withdrawV3Params);


    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/withdrawal")
    Call<OpnxV3RestResponse<List<WithdrawHistoryV3Resp>>> getWithdrawalHistory(@Query("id") String id,
                                                                               @Query("asset") String asset,
                                                                               @Query("limit") Long limit,
                                                                               @Query("startTime") Long startTime,
                                                                               @Query("endTime") Long endTime);

    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @HTTP(method = "DELETE", path = "/v3/orders/cancel", hasBody = true)
    Call<OpnxV3RestResponse<List<OrderCancelV3Resp>>> cancelAccountOrder(@Body BatchOrderRequest batchOrderRequest);



    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @HTTP(method = "DELETE", path = "/v3/orders/cancel-all", hasBody = true)
    Call<OpnxV3RestResponse<OrderCancelAllResp>> cancelAccountAllOrder(@Body OrderCancelAllParamV3 orderCancelAllParamV3);



    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/orders/place")
    Call<OpnxV3RestResponse<List<OrderPlaceRespV3>>> accountPlaceOrder(@Body BatchOrderRequest batchOrderRequest);


    @GET("/v3/leverage/tiers")
    Call<OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>>> getLeverageTiersByMarketCode(@Query("marketCode") String marketCode);

}
