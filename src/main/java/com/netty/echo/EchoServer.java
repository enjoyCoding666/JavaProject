package com.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 服务端收到客户端的消息后，会进行响应。
 */
public final class EchoServer {
    /**
     * 端口
     */
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

    public static void main(String[] args) throws Exception {
        // 配置 EventLoopGroup
        // 主从 Reactor 多线程模式，bossGroup是 主 Reactor，workerGroup是 从Reactor
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //初始化服务器的引导类 ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //指定 EventLoopGroup
            serverBootstrap.group(bossGroup, workerGroup)
                    //指定 channel
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    //指定 ChannelHandler，用于处理 Channel
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //ChannelPipeline，基于责任链模式，可以添加多个 ChannelHandler
                            ChannelPipeline channelPipeline = ch.pipeline();
                            //ChannelHandler，用于处理 channel，实现对接收的数据的处理，实现业务逻辑。
                            //固定长度的拆包器 FixedLengthFrameDecoder
                            channelPipeline.addLast(new FixedLengthFrameDecoder(19));
                            channelPipeline.addLast(new EchoServerHandler());
                        }
                    });

            // 开启服务器，将服务器绑定到它要监听连接请求的端口上
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();

            // 等待直到服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            //关闭所有 eventLoop，终止线程
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
