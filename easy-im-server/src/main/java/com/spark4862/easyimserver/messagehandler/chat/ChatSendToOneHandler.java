package com.spark4862.easyimserver.messagehandler.chat;

import com.spark4862.easyimcommon.codec.Invocation;
import com.spark4862.easyimcommon.dispatcher.MessageHandler;
import com.spark4862.easyimcommon.message.chat.ChatSendResponse;
import com.spark4862.easyimcommon.message.chat.ChatSendToOneRequest;
import com.spark4862.easyimcommon.message.chat.ChatRedirectToUserRequest;
import com.spark4862.easyimserver.server.NettyChannelManager;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatSendToOneHandler implements MessageHandler<ChatSendToOneRequest> {

  @Autowired
  private NettyChannelManager nettyChannelManager;

  @Override
  public void execute(Channel channel, ChatSendToOneRequest message) {
    // 假装成功
    ChatSendResponse sendResponse = new ChatSendResponse().setMsgId(message.getMsgId()).setCode(0);
    channel.writeAndFlush(new Invocation(ChatSendResponse.TYPE, sendResponse));

    // 创建转发的消息，发送给指定用户
    ChatRedirectToUserRequest sendToUserRequest = new ChatRedirectToUserRequest().setMsgId(message.getMsgId())
        .setContent(message.getContent());
    nettyChannelManager.send(message.getToUser(),
        new Invocation(ChatRedirectToUserRequest.TYPE, sendToUserRequest));
  }

  @Override
  public String getType() {
    return ChatSendToOneRequest.TYPE;
  }

}
