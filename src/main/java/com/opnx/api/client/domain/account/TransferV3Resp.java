package com.opnx.api.client.domain.account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferV3Resp {
    private String asset;
    private String quantity;
    private String fromAccount;
    private String toAccount;
    private String transferredAt;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getTransferredAt() {
        return transferredAt;
    }

    public void setTransferredAt(String transferredAt) {
        this.transferredAt = transferredAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("quantity", quantity)
                .append("fromAccount", fromAccount)
                .append("toAccount", toAccount)
                .append("transferredAt", transferredAt)
                .toString();
    }
}
