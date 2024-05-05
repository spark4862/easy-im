package com.spark4862.easyimclient.config;

import com.spark4862.easyimcommon.dispatcher.MessageDispatcher;
import com.spark4862.easyimcommon.dispatcher.MessageHandlerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NettyClientConfig {

  @Bean
  public MessageDispatcher messageDispatcher() {
    return new MessageDispatcher();
  }

  @Bean
  public MessageHandlerContainer messageHandlerContainer() {
    return new MessageHandlerContainer();
  }
}
