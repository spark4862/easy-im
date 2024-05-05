package com.spark4862.easyimclient.client.handler;

import com.spark4862.easyimclient.client.NettyClient;
import com.spark4862.easyimcommon.message.heartbeat.HeartbeatRequest;
import com.spark4862.easyimcommon.codec.Invocation;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Sharable
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

  @Autowired
  private NettyClient nettyClient;

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    // 发起重连
    nettyClient.reconnect();
    // 继续触发事件
    super.channelInactive(ctx);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    log.error("[exceptionCaught][连接({}) 发生异常]", ctx.channel().id(), cause);
    // 断开连接
    ctx.channel().close();
  }

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object event) throws Exception {
    // 空闲时，向服务端发起一次心跳
    if (event instanceof IdleStateEvent) {
      log.info("[userEventTriggered][发起一次心跳]");
      HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
      ctx.writeAndFlush(new Invocation(HeartbeatRequest.TYPE, heartbeatRequest))
          .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    } else {
      super.userEventTriggered(ctx, event);
    }
  }
}
