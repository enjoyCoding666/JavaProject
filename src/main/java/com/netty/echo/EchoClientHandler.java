package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户端 的 ChannelHandler.
 */
@Slf4j
public class EchoClientHandler extends ChannelInboundHandlerAdapter {


    /**
     * channelActive() 客户端跟服务器的连接建立之后将被调用.
     *
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf firstMessage = Unpooled.buffer(EchoClient.SIZE);
        byte[] bytes = "见到你很高兴^_^\n".getBytes(CharsetUtil.UTF_8);
        firstMessage.writeBytes(bytes);
        //向服务器发送数据
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        log.info("服务器发来的消息：" + buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

