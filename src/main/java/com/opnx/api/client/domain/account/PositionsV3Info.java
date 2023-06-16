package com.opnx.api.client.domain.account;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionsV3Info {
    private String marketCode;
    private String baseAsset;
    private String counterAsset;
    private String position;
    private String entryPrice;
    private String markPrice;
    private String positionPnl;
    private String estLiquidationPrice;
    private String lastUpdatedAt;
    private String marginBalance;
    private String maintenanceMargin;
    private String marginRatio;
    private String leverage;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getCounterAsset() {
        return counterAsset;
    }

    public void setCounterAsset(String counterAsset) {
        this.counterAsset = counterAsset;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(String markPrice) {
        this.markPrice = markPrice;
    }

    public String getPositionPnl() {
        return positionPnl;
    }

    public void setPositionPnl(String positionPnl) {
        this.positionPnl = positionPnl;
    }

    public String getEstLiquidationPrice() {
        return estLiquidationPrice;
    }

    public void setEstLiquidationPrice(String estLiquidationPrice) {
        this.estLiquidationPrice = estLiquidationPrice;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(String marginBalance) {
        this.marginBalance = marginBalance;
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

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("marketCode", marketCode)
                .append("baseAsset", baseAsset)
                .append("counterAsset", counterAsset)
                .append("position", position)
                .append("entryPrice", entryPrice)
                .append("markPrice", markPrice)
                .append("positionPnl", positionPnl)
                .append("estLiquidationPrice", estLiquidationPrice)
                .append("lastUpdatedAt", lastUpdatedAt)
                .append("marginBalance", marginBalance)
                .append("maintenanceMargin", maintenanceMargin)
                .append("marginRatio", marginRatio)
                .append("leverage", leverage)
                .toString();
    }
}
