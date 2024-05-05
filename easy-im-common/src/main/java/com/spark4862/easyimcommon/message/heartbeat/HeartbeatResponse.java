package com.spark4862.easyimcommon.message.heartbeat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 消息 - 心跳响应
 */
@Data
public class HeartbeatResponse implements Message {

  /**
   * 类型 - 心跳响应
   */
  public static final String TYPE = "HEARTBEAT_RESPONSE";

}
