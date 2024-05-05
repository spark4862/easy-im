package com.spark4862.easyimcommon.message.auth;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 用户认证请求
 */
@Data
public class AuthRequest implements Message {

  public static final String TYPE = "AUTH_REQUEST";

  private String accessToken;

  public AuthRequest setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

}
