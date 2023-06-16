package com.opnx.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawV3Resp {
    private String id;
    private String asset;
    private String network;
    private String address;
    private String memo;
    private String quantity;
    private Boolean externalFee;
    private String fee;
    private String status;
    private String requestedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Boolean getExternalFee() {
        return externalFee;
    }

    public void setExternalFee(Boolean externalFee) {
        this.externalFee = externalFee;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("id", id)
                .append("asset", asset)
                .append("network", network)
                .append("address", address)
                .append("memo", memo)
                .append("quantity", quantity)
                .append("externalFee", externalFee)
                .append("fee", fee)
                .append("status", status)
                .append("requestedAt", requestedAt)
                .toString();
    }
}
