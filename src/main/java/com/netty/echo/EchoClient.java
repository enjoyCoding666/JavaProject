package com.netty.echo;

import com.netty.decoder.ClientNoDecoderHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

/**
 * 客户端。发送消息给服务端，并接收服务端的响应。
 *
 */
public final class EchoClient {

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline channelPipeline = socketChannel.pipeline();
                            //ChannelHandler，用于处理 channel，实现对接收的数据的处理，实现业务逻辑。
                            //固定长度的拆包器 FixedLengthFrameDecoder
                            channelPipeline.addLast(new FixedLengthFrameDecoder(19));
                            channelPipeline.addLast(new ClientNoDecoderHandler());
//                            channelPipeline.addLast(new EchoClientHandler());
                        }
                    });

            // 开启客户端，连接服务端的端口
            ChannelFuture channelFuture = bootstrap.connect(HOST, PORT).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
