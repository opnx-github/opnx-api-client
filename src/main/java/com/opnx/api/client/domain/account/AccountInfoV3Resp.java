package com.opnx.api.client.domain.account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountInfoV3Resp {
    private String accountId;
    private String hashToken;
    private String name;
    private String accountType;
    private List<BalancesInfo> balances;
    private List<PositionsInfo> positions;
    private String collateral;
    private String notionalPositionSize;
    private String portfolioVarMargin;
    private String riskRatio;
    private String maintenanceMargin;
    private String marginRatio;
    private Boolean liquidating;
    private String feeTier;
    private String createdAt;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getHashToken() {
        return hashToken;
    }

    public void setHashToken(String hashToken) {
        this.hashToken = hashToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<BalancesInfo> getBalances() {
        return balances;
    }

    public void setBalances(List<BalancesInfo> balances) {
        this.balances = balances;
    }

    public List<PositionsInfo> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionsInfo> positions) {
        this.positions = positions;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public String getNotionalPositionSize() {
        return notionalPositionSize;
    }

    public void setNotionalPositionSize(String notionalPositionSize) {
        this.notionalPositionSize = notionalPositionSize;
    }

    public String getPortfolioVarMargin() {
        return portfolioVarMargin;
    }

    public void setPortfolioVarMargin(String portfolioVarMargin) {
        this.portfolioVarMargin = portfolioVarMargin;
    }

    public String getRiskRatio() {
        return riskRatio;
    }

    public void setRiskRatio(String riskRatio) {
        this.riskRatio = riskRatio;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public void setMaintenanceMargin(String maintenanceMargin) {
        this.maintenanceMargin = maintenanceMargin;
    }

    public String getMarginRatio() {
        return marginRatio;
    }

    public void setMarginRatio(String marginRatio) {
        this.marginRatio = marginRatio;
    }

    public Boolean getLiquidating() {
        return liquidating;
    }

    public void setLiquidating(Boolean liquidating) {
        this.liquidating = liquidating;
    }

    public String getFeeTier() {
        return feeTier;
    }

    public void setFeeTier(String feeTier) {
        this.feeTier = feeTier;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("accountId", accountId)
                .append("hashToken", hashToken)
                .append("name", name)
                .append("accountType", accountType)
                .append("balances", balances)
                .append("positions", positions)
                .append("collateral", collateral)
                .append("notionalPositionSize", notionalPositionSize)
                .append("portfolioVarMargin", portfolioVarMargin)
                .append("riskRatio", riskRatio)
                .append("maintenanceMargin", maintenanceMargin)
                .append("marginRatio", marginRatio)
                .append("liquidating", liquidating)
                .append("feeTier", feeTier)
                .append("createdAt", createdAt)
                .toString();
    }
}
