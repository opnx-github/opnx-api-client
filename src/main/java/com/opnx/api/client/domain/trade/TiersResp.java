package com.opnx.api.client.domain.trade;

import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TiersResp {
    private Integer tier;
    private String leverage;
    private String positionFloor;
    private String positionCap;
    private String initialMargin;
    private String maintenanceMargin;

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getPositionFloor() {
        return positionFloor;
    }

    public void setPositionFloor(String positionFloor) {
        this.positionFloor = positionFloor;
    }

    public String getPositionCap() {
        return positionCap;
    }

    public void setPositionCap(String positionCap) {
        this.positionCap = positionCap;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public void setMaintenanceMargin(String maintenanceMargin) {
        this.maintenanceMargin = maintenanceMargin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("tier", tier)
                .append("leverage", leverage)
                .append("positionFloor", positionFloor)
                .append("positionCap", positionCap)
                .append("initialMargin", initialMargin)
                .append("maintenanceMargin", maintenanceMargin)
                .toString();
    }
}



