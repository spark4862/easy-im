package com.spark4862.easyimserver.server.handler;

import com.spark4862.easyimserver.server.NettyChannelManager;
import io.netty.channel.ChannelHandler.Sharable;
import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 服务端 Channel 实现类，提供对客户端 Channel 建立连接、断开连接、异常时的处理
 */
@Slf4j
@Component
@Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

  @Autowired
  private NettyChannelManager channelManager;

  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    // 从管理器中添加
    channelManager.add(ctx.channel());
  }

  @Override
  public void channelUnregistered(ChannelHandlerContext ctx) {
    // 从管理器中移除
    channelManager.remove(ctx.channel());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    log.error("[exceptionCaught][连接({}) 发生异常]", ctx.channel().id(), cause);
    // 断开连接
    ctx.channel().close();
  }

}
