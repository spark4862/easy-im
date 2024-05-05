# 简易即时通信软件 easyIm
+ 支持消息单发和群发
+ 支持心跳保活和服务器自动断开超时连接
+ 基于netty框架开发，具有高可用性
+ 在报文头部附加长度字段解决拆包问题

# 使用方法
+ 安装easy-im-common至本地仓库
+ 运行easy-im-server，在yml文件中配置监听端口
+ 运行easy-im-client，在yml文件中配置服务器地址和端口
  
# easy-im-client命令行
+ rigister-name/r name 向服务器注册用户名
+ send/s --user/-u user --message/-m message 向user发送message
+ send-all/as --message/-m message 向所有用户发送message