package com.opnx.api.client.domain.messages;

public class CancelorderCommand{

    private String	op;
    private String	tag;
    private CancelorderCommandData	data;

    public String getOp() {
      return this.op;
    }

    public void setOp(String op) {
      this.op = op;
    }

    public String getTag() {
      return this.tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

    public CancelorderCommandData getData() {
      return this.data;
    }

    public void setData(CancelorderCommandData data) {
      this.data = data;
    }

}
