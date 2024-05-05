package com.spark4862.easyimcommon.message.chat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 发送给指定人的私聊消息 Request
 */
@Data
public class ChatSendToOneRequest implements Message {

  public static final String TYPE = "CHAT_SEND_TO_ONE_REQUEST";

  /**
   * 发送给的用户
   */
  private String toUser;
  /**
   * 消息编号
   */
  private String msgId;
  /**
   * 内容
   */
  private String content;

  public ChatSendToOneRequest setToUser(String toUser) {
    this.toUser = toUser;
    return this;
  }

  public ChatSendToOneRequest setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  public ChatSendToOneRequest setContent(String content) {
    this.content = content;
    return this;
  }
}
