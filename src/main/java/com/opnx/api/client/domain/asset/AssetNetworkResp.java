package com.opnx.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetNetworkResp {
    private String network;
    private String tokenId;
    private String transactionPrecision;
    private Boolean isWithdrawalFeeChargedToUser;
    private Boolean canDeposit;
    private Boolean canWithdraw;
    private String minDeposit;
    private String minWithdrawal;

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTransactionPrecision() {
        return transactionPrecision;
    }

    public void setTransactionPrecision(String transactionPrecision) {
        this.transactionPrecision = transactionPrecision;
    }

    public Boolean getWithdrawalFeeChargedToUser() {
        return isWithdrawalFeeChargedToUser;
    }

    public void setWithdrawalFeeChargedToUser(Boolean withdrawalFeeChargedToUser) {
        isWithdrawalFeeChargedToUser = withdrawalFeeChargedToUser;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public String getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(String minDeposit) {
        this.minDeposit = minDeposit;
    }

    public String getMinWithdrawal() {
        return minWithdrawal;
    }

    public void setMinWithdrawal(String minWithdrawal) {
        this.minWithdrawal = minWithdrawal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("network", network)
                .append("tokenId", tokenId)
                .append("transactionPrecision", transactionPrecision)
                .append("isWithdrawalFeeChargedToUser", isWithdrawalFeeChargedToUser)
                .append("canDeposit", canDeposit)
                .append("canWithdraw", canWithdraw)
                .append("minDeposit", minDeposit)
                .append("minWithdrawal", minWithdrawal)
                .toString();
    }
}
