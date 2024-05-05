package com.spark4862.easyimcommon.message.auth;

import com.spark4862.easyimcommon.dispatcher.Message;

import lombok.Data;

/**
 * 用户认证响应
 */
@Data
public class AuthResponse implements Message {

  public static final String TYPE = "AUTH_RESPONSE";

  /**
   * 响应状态码
   */
  private Integer code;
  /**
   * 响应提示
   */
  private String message;

  public AuthResponse setCode(Integer code) {
    this.code = code;
    return this;
  }

  public AuthResponse setMessage(String message) {
    this.message = message;
    return this;
  }

}
