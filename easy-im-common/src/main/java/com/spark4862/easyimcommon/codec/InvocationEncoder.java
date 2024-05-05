package com.spark4862.easyimcommon.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link Invocation} 编码器
 */
@Slf4j
public class InvocationEncoder extends MessageToByteEncoder<Invocation> {

  @Override
  protected void encode(ChannelHandlerContext ctx, Invocation invocation, ByteBuf out) {
    // 将 Invocation 转换成 byte[] 数组
    byte[] content = JSON.toJSONBytes(invocation);
    // 写入 length
    out.writeInt(content.length);
    // 写入内容
    out.writeBytes(content);
    log.info("[encode][连接({}) 编码了一条消息({})]", ctx.channel().id(), invocation.toString());
  }

}
