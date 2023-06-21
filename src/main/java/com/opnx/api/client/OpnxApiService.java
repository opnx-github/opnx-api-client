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


    /**
     * GET /v3/tickers?marketCode={marketCode}
     *
     * @param marketCode
     * @return
     */
    @GET("/v3/tickers")
    Call<OpnxV3RestResponse<List<TickerV3Resp>>> getTickersByMarketCode(@Query("marketCode") String marketCode);

    /**
     * GET /v3/markets?marketCode={marketCode}
     *
     * @param marketCode
     * @return
     */
    @GET("/v3/markets")
    Call<OpnxV3RestResponse<List<MarketsV3Resp>>> getMarketsByMarketCode(@Query("marketCode") String marketCode);

    /**
     * GET /v3/assets?asset={asset}
     *
     * @param asset
     * @return
     */
    @GET("/v3/assets")
    Call<OpnxV3RestResponse<List<AssetsV3Resp>>> getAssetsByAsset(@Query("asset") String asset);


    /**
     * GET /v3/funding/estimates?marketCode={marketCode}
     *
     * @param marketCode
     * @return
     */
    @GET("/v3/funding/estimates")
    Call<OpnxV3RestResponse<List<FundingEstimateV3Resp>>> getFundingEstimatesByMarketCode(@Query("marketCode") String marketCode);

    /**
     * GET /v3/candles?marketCode={marketCode}&timeframe={timeframe}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param marketCode
     * @param timeframe
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/v3/candles")
    Call<OpnxV3RestResponse<List<CandlesV3Resp>>> getCandles(@Query("marketCode") String marketCode,
                                                             @Query("timeframe") String timeframe,
                                                             @Query("limit") Long limit,
                                                             @Query("startTime") Long startTime,
                                                             @Query("endTime") Long endTime);

    /**
     * GET /v3/depth?marketCode={marketCode}&level={level}
     *
     * @param marketCode
     * @param level
     * @return
     */
    @GET("/v3/depth")
    Call<OpnxV3RestResponse<DepthV3Resp>> getDepths(@Query("marketCode") String marketCode,
                                                    @Query("level") Long level);

    /**
     * GET /v3/exchange-trades?marketCode={marketCode}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param marketCode
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/v3/exchange-trades")
    Call<OpnxV3RestResponse<List<PublicTradesV3Resp>>> getPublicTrades(@Query("marketCode") String marketCode,
                                                                       @Query("limit") Long limit,
                                                                       @Query("startTime") Long startTime,
                                                                       @Query("endTime") Long endTime);


    /**
     * GET /v3/funding/rates?marketCode={marketCode}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param marketCode
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @GET("/v3/funding/rates")
    Call<OpnxV3RestResponse<List<FundingRatesV3Resp>>> getFundingRates(@Query("marketCode") String marketCode,
                                                                       @Query("limit") Long limit,
                                                                       @Query("startTime") Long startTime,
                                                                       @Query("endTime") Long endTime);


//    private api

    /**
     * /v3/trades?marketCode={marketCode}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param marketCode
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/trades")
    Call<OpnxV3RestResponse<List<TradesV3Resp>>> getAccountTrades(@Query("marketCode") String marketCode,
                                                                  @Query("limit") Long limit,
                                                                  @Query("startTime") Long startTime,
                                                                  @Query("endTime") Long endTime);


    /**
     * /v3/funding?marketCode={marketCode}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param marketCode
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/funding")
    Call<OpnxV3RestResponse<List<FundingPaymentsV3Resp>>> getAccountFundingPayments(@Query("marketCode") String marketCode,
                                                                                    @Query("limit") Long limit,
                                                                                    @Query("startTime") Long startTime,
                                                                                    @Query("endTime") Long endTime);


    /**
     * /v3/orders/working?marketCode={marketCode}&orderId={orderId}&clientOrderId={clientOrderId}
     *
     * @param marketCode
     * @param orderId
     * @param clientOrderId
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/orders/working")
    Call<OpnxV3RestResponse<List<WorkingOrderV3Resp>>> getOpenOrders(@Query("marketCode") String marketCode,
                                                                     @Query("orderId") Long orderId,
                                                                     @Query("clientOrderId") Long clientOrderId);


    /**
     * /v3/orders/status?orderId={orderId}&clientOrderId={clientOrderId}
     *
     * @param orderId
     * @param clientOrderId
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/orders/status")
    Call<OpnxV3RestResponse<OrderHistoryV3Resp>> getOrdersStatus(@Query("orderId") Long orderId, @Query("clientOrderId") Long clientOrderId);


    /**
     * GET /v3/account/names
     *
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/account/names")
    Call<OpnxV3RestResponse<List<SubAccountInfoV3Resp>>> getSubAccounts();


    /**
     * GET v3/account?subAcc={subAcc},{subAcc}
     *
     * @param subAcc
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/account")
    Call<OpnxV3RestResponse<List<AccountInfoV3Resp>>> getAccountInfo(@Query("subAcc") List<String> subAcc);


    /**
     * GET /v3/balances?subAcc={name1},{name2}&asset={asset}
     *
     * @param subAcc
     * @param asset
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/balances")
    Call<OpnxV3RestResponse<List<BalanceV3Resp>>> getAccountBalance(@Query("subAcc") List<String> subAcc, @Query("asset") String asset);

    /**
     * /v3/positions?subAcc={name1},{name2}&marketCode={marketCode}
     *
     * @param subAcc
     * @param marketCode
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/positions")
    Call<OpnxV3RestResponse<List<PositionsV3Resp>>> getAccountPositions(@Query("subAcc") List<String> subAcc, @Query("marketCode") String marketCode);

    //POST /v3/transfer

    /**
     * /v3/transfer
     *
     * @param transferParam
     * @return
     */
    //@POST("/v2/account/public/v3/transfer")
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/transfer")
    Call<OpnxV3RestResponse<TransferV3Resp>> accountTransfer(@Body TransferV3Param transferParam);


    /**
     * /v3/transfer?asset={asset}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param asset
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/transfer")
    Call<OpnxV3RestResponse<List<TransferHistoryV3Rsp>>> getTransferHistory(@Query("asset") String asset,
                                                                            @Query("limit") Long limit,
                                                                            @Query("startTime") Long startTime,
                                                                            @Query("endTime") Long endTime);


    /**
     * /v3/deposit-addresses?asset={asset}&network={network}
     *
     * @param asset
     * @param network
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/deposit-addresses")
    Call<OpnxV3RestResponse<DepositAddressV3Resp>> getDepositAddresses(@Query("asset") String asset, @Query("network") String network);


    /**
     * /v3/deposit?asset={asset}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param asset
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/deposit")
    Call<OpnxV3RestResponse<List<DepositHistoryV3Resp>>> getDepositHistory(@Query("asset") String asset,
                                                                           @Query("limit") Long limit,
                                                                           @Query("startTime") Long startTime,
                                                                           @Query("endTime") Long endTime);


    /**
     * POST /v3/withdrawal
     *
     * @param withdrawV3Params
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/withdrawal")
    Call<OpnxV3RestResponse<WithdrawV3Resp>> accountWithdrawal(@Body WithdrawV3Params withdrawV3Params);


    /**
     * /v3/withdrawal?id={id}&asset={asset}&limit={limit}&startTime={startTime}&endTime={endTime}
     *
     * @param id
     * @param asset
     * @param limit
     * @param startTime
     * @param endTime
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/v3/withdrawal")
    Call<OpnxV3RestResponse<List<WithdrawHistoryV3Resp>>> getWithdrawalHistory(@Query("id") String id,
                                                                               @Query("asset") String asset,
                                                                               @Query("limit") Long limit,
                                                                               @Query("startTime") Long startTime,
                                                                               @Query("endTime") Long endTime);


    /**
     * DELETE /v3/orders/cancel
     *
     * @param batchOrderRequest
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @HTTP(method = "DELETE", path = "/v3/orders/cancel", hasBody = true)
    Call<OpnxV3RestResponse<List<OrderCancelV3Resp>>> cancelAccountOrder(@Body BatchOrderRequest batchOrderRequest);


    /**
     * /v3/orders/cancel-all
     *
     * @param orderCancelAllParamV3
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @HTTP(method = "DELETE", path = "/v3/orders/cancel-all", hasBody = true)
    Call<OpnxV3RestResponse<OrderCancelAllResp>> cancelAccountAllOrder(@Body OrderCancelAllParamV3 orderCancelAllParamV3);


    /**
     * POST /v3/orders/place
     *
     * @param batchOrderRequest
     * @return
     */
    @Headers({OpnxApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/v3/orders/place")
    Call<OpnxV3RestResponse<List<OrderPlaceRespV3>>> accountPlaceOrder(@Body BatchOrderRequest batchOrderRequest);

    /**
     *  GET /v3/leverage/tiers
     * @param marketCode
     * @return
     */
    @GET("/v3/leverage/tiers")
    Call<OpnxV3RestResponse<List<LeverageTiersInfoV3Resp>>> getLeverageTiersByMarketCode(@Query("marketCode") String marketCode);


}
