package com.spark4862.easyimclient.messagehandler.chat;

import com.spark4862.easyimcommon.message.chat.ChatSendResponse;
import com.spark4862.easyimcommon.dispatcher.MessageHandler;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatSendResponseHandler implements MessageHandler<ChatSendResponse> {

  @Override
  public void execute(Channel channel, ChatSendResponse message) {
    log.info("[execute][收到发送响应：{}]", message);
  }

  @Override
  public String getType() {
    return ChatSendResponse.TYPE;
  }
}
