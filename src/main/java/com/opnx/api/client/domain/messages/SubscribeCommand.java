package com.opnx.api.client.domain.messages;

import java.util.List;

public class SubscribeCommand{

    private String	op;
    private List<String> args;
    private String	tag;

    public String getOp() {
      return this.op;
    }

    public void setOp(String op) {
      this.op = op;
    }

    public List<String> getArgs() {
      return this.args;
    }

    public void setArgs(List<String> args) {
      this.args = args;
    }

    public String getTag() {
      return this.tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

}
