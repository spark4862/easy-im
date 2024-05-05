package com.spark4862.easyimclient.controller;

import com.spark4862.easyimclient.client.NettyClient;
import com.spark4862.easyimcommon.codec.Invocation;
import com.spark4862.easyimcommon.message.auth.AuthRequest;
import com.spark4862.easyimcommon.message.chat.ChatSendToAllRequest;
import com.spark4862.easyimcommon.message.chat.ChatSendToOneRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ClientShell {

  @Autowired
  private NettyClient nettyClient;

  private static int msgId = 0;

  @ShellMethod(value = "send message to one user", key = { "send", "s" })
  public void send(@ShellOption({ "--user", "-u" }) String user, @ShellOption({ "--message", "-m" }) String message) {
    ChatSendToOneRequest chatSendToOneRequest = new ChatSendToOneRequest();
    chatSendToOneRequest.setToUser(user);
    chatSendToOneRequest.setMsgId(String.valueOf(++msgId));
    chatSendToOneRequest.setContent(message);
    Invocation invocation = new Invocation(ChatSendToOneRequest.TYPE, chatSendToOneRequest);
    nettyClient.send(invocation);
  }

  @ShellMethod(value = "send message to all user", key = { "send-all", "sa" })
  public void sendAll(@ShellOption({ "--message", "-m" }) String message) {
    ChatSendToAllRequest chatSendToAllRequest = new ChatSendToAllRequest();
    chatSendToAllRequest.setMsgId(String.valueOf(++msgId));
    chatSendToAllRequest.setContent(message);
    Invocation invocation = new Invocation(ChatSendToAllRequest.TYPE, chatSendToAllRequest);
    nettyClient.send(invocation);
  }

  @ShellMethod(value = "register name to server", key = { "register-name", "r" })
  public void registerName(String accessToken) {
    AuthRequest authRequest = new AuthRequest();
    authRequest.setAccessToken(accessToken);
    Invocation invocation = new Invocation(AuthRequest.TYPE, authRequest);
    nettyClient.send(invocation);
  }
}
