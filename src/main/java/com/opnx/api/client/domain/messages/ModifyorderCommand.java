package com.opnx.api.client.domain.messages;

public class ModifyorderCommand{

    private String	op;
    private String	tag;
    private ModifyorderCommandData	data;

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

    public ModifyorderCommandData getData() {
      return this.data;
    }

    public void setData(ModifyorderCommandData data) {
      this.data = data;
    }

}
