package com.spark4862.easyimclient.controller;

import com.spark4862.easyimclient.client.NettyClient;
import com.spark4862.easyimcommon.codec.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private NettyClient nettyClient;

  @PostMapping("/mock")
  public String mock(String type, String message) {
    // 创建 Invocation 对象
    Invocation invocation = new Invocation(type, message);
    // 发送消息
    nettyClient.send(invocation);
    return "success";
  }
}