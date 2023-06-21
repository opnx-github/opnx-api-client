package com.opnx.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceV3Resp {
    private String accountId;
    private String name;
    private List<BalancesInfo> balances;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BalancesInfo> getBalances() {
        return balances;
    }

    public void setBalances(List<BalancesInfo> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("accountId", accountId)
                .append("name", name)
                .append("balances", balances)
                .toString();
    }
}
