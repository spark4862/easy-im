package com.spark4862.easyimcommon.message.chat;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 转发消息给一个用户的 Message
 */
@Data
public class ChatRedirectToUserRequest implements Message {

  public static final String TYPE = "CHAT_REDIRECT_TO_USER_REQUEST";

  /**
   * 消息编号
   */
  private String msgId;
  /**
   * 内容
   */
  private String content;

  public ChatRedirectToUserRequest setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  public ChatRedirectToUserRequest setContent(String content) {
    this.content = content;
    return this;
  }

}
