package com.spark4862.easyimclient.messagehandler.auth;

import com.spark4862.easyimcommon.message.auth.AuthResponse;
import com.spark4862.easyimcommon.dispatcher.MessageHandler;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthResponseHandler implements MessageHandler<AuthResponse> {

  @Override
  public void execute(Channel channel, AuthResponse message) {
    log.info("[execute][认证结果：{}]", message);
  }

  @Override
  public String getType() {
    return AuthResponse.TYPE;
  }
}
