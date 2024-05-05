package com.spark4862.easyimcommon.codec;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.alibaba.fastjson.JSON;

/**
 * 通信协议的消息体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invocation {

  /**
   * 类型
   */
  private String type;
  /**
   * 消息，JSON 格式
   */
  private String message;

  public Invocation(String type, Message message) {
    this.type = type;
    this.message = JSON.toJSONString(message);
  }

  public Invocation setType(String type) {
    this.type = type;
    return this;
  }

  public Invocation setMessage(String message) {
    this.message = message;
    return this;
  }

}
