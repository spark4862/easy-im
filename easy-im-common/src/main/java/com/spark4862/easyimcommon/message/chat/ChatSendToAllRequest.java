package com.spark4862.easyimcommon.message.chat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 发送给所有人的群聊消息的 Message
 */
@Data
public class ChatSendToAllRequest implements Message {

  public static final String TYPE = "CHAT_SEND_TO_ALL_REQUEST";

  /**
   * 消息编号
   */
  private String msgId;
  /**
   * 内容
   */
  private String content;

  public ChatSendToAllRequest setContent(String content) {
    this.content = content;
    return this;
  }

  public ChatSendToAllRequest setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

}
