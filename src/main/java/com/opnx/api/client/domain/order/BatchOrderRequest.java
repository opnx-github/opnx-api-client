package com.opnx.api.client.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opnx.api.client.constant.OpnxApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchOrderRequest {
    private Integer recvWindow;
    private String responseType;
    private Long timestamp;

    private List<OrderRequest> orders;

    public Integer getRecvWindow() {
        return recvWindow;
    }

    public void setRecvWindow(Integer recvWindow) {
        this.recvWindow = recvWindow;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<OrderRequest> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderRequest> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, OpnxApiConstants.TO_STRING_BUILDER_STYLE)
                .append("recvWindow", recvWindow)
                .append("responseType", responseType)
                .append("timestamp", timestamp)
                .append("orders", orders)
                .toString();
    }
}
