package com.spark4862.easyimcommon.message.chat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 聊天发送消息结果的 Response
 */
@Data
public class ChatSendResponse implements Message {

  public static final String TYPE = "CHAT_SEND_RESPONSE";

  /**
   * 消息编号
   */
  private String msgId;
  /**
   * 响应状态码
   */
  private Integer code;
  /**
   * 响应提示
   */
  private String message;

  public ChatSendResponse setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  public ChatSendResponse setCode(Integer code) {
    this.code = code;
    return this;
  }

  public ChatSendResponse setMessage(String message) {
    this.message = message;
    return this;
  }
}
