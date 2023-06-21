package com.opnx.api.client.domain.account;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionsV3Resp {
    private String accountId;
    private String name;
    private List<PositionsV3Info> positions;

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

    public List<PositionsV3Info> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionsV3Info> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("accountId", accountId)
                .append("name", name)
                .append("positions", positions)
                .toString();
    }
}
