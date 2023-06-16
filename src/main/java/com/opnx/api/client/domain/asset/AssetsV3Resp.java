package com.opnx.api.client.domain.asset;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetsV3Resp {
    private String asset;
    private Boolean isCollateral;
    private String loanToValue;
    private String loanToValueFactor;
    private List<AssetNetworkResp> networkList;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Boolean getCollateral() {
        return isCollateral;
    }

    public void setCollateral(Boolean collateral) {
        isCollateral = collateral;
    }

    public String getLoanToValue() {
        return loanToValue;
    }

    public void setLoanToValue(String loanToValue) {
        this.loanToValue = loanToValue;
    }

    public List<AssetNetworkResp> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(List<AssetNetworkResp> networkList) {
        this.networkList = networkList;
    }

    public String getLoanToValueFactor() {
        return loanToValueFactor;
    }

    public void setLoanToValueFactor(String loanToValueFactor) {
        this.loanToValueFactor = loanToValueFactor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("asset", asset)
                .append("isCollateral", isCollateral)
                .append("loanToValue", loanToValue)
                .append("loanToValueFactor", loanToValueFactor)
                .append("networkList", networkList)
                .toString();
    }
}
