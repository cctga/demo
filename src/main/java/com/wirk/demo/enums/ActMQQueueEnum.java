package com.wirk.demo.enums;

public enum ActMQQueueEnum {
  ASYNC_SAVE(0, "user.async.save"),
  QUEUE(1, "user.queue");

  private int code;
  private String des;

  ActMQQueueEnum(int code, String des) {
    this.code = code;
    this.des = des;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDes() {
    return des;
  }

  public void setDes(String des) {
    this.des = des;
  }
}
