package com.spark4862.easyimcommon.message.heartbeat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 消息 - 心跳请求
 */
@Data
public class HeartbeatRequest implements Message {

  /**
   * 类型 - 心跳请求
   */
  public static final String TYPE = "HEARTBEAT_REQUEST";

}
