package com.opnx.api.client.domain.account;

import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class WithdrawV3Params {
    private String asset;
    private String network;
    private String address;
    private String memo;
    private BigDecimal quantity;
    private Boolean externalFee;
    private String code;
    private String tfaType;
    private BigDecimal fee;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Boolean getExternalFee() {
        return externalFee;
    }

    public void setExternalFee(Boolean externalFee) {
        this.externalFee = externalFee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTfaType() {
        return tfaType;
    }

    public void setTfaType(String tfaType) {
        this.tfaType = tfaType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("network", network)
                .append("address", address)
                .append("memo", memo)
                .append("quantity", quantity)
                .append("externalFee", externalFee)
                .append("code", code)
                .append("tfaType", tfaType)
                .append("fee", fee)
                .toString();
    }
}
