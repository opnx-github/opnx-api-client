package com.opnx.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositHistoryV3Resp {
    private String asset;
    private String network;
    private String address;
    private String memo;
    private String quantity;
    private String id;
    private String status;
    private String txId;
    private String creditedAt;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getCreditedAt() {
        return creditedAt;
    }

    public void setCreditedAt(String creditedAt) {
        this.creditedAt = creditedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("network", network)
                .append("address", address)
                .append("memo", memo)
                .append("quantity", quantity)
                .append("id", id)
                .append("status", status)
                .append("txId", txId)
                .append("creditedAt", creditedAt)
                .toString();
    }
}
