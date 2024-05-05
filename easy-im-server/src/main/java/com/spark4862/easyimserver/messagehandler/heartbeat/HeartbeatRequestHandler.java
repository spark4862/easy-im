package com.spark4862.easyimserver.messagehandler.heartbeat;

import com.spark4862.easyimcommon.codec.Invocation;
import com.spark4862.easyimcommon.dispatcher.MessageHandler;
import com.spark4862.easyimcommon.message.heartbeat.HeartbeatRequest;
import com.spark4862.easyimcommon.message.heartbeat.HeartbeatResponse;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeartbeatRequestHandler implements MessageHandler<HeartbeatRequest> {

  @Override
  public void execute(Channel channel, HeartbeatRequest message) {
    log.info("[execute][收到连接({}) 的心跳请求]", channel.id());
    // 响应心跳
    HeartbeatResponse response = new HeartbeatResponse();
    channel.writeAndFlush(new Invocation(HeartbeatResponse.TYPE, response));
  }

  @Override
  public String getType() {
    return HeartbeatRequest.TYPE;
  }

}
