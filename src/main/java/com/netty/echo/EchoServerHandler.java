package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端的 ChannelHandler.
 *
 * ChannelHandler，用于处理 channel，实现对接收的数据的处理，实现业务逻辑。
 * 继承 ChannelInboundHandlerAdapter，用来定义响应入站事件的方法。
 *
 */
@ChannelHandler.Sharable
@Slf4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * channelRead() ：读取 channel 传入的消息
     *
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf= (ByteBuf) msg;
        log.info("客户端发来的消息："+ buf.toString(CharsetUtil.UTF_8) +"\n");
    }

    /**
     * channelReadComplete() ：表示当前 ChannelHandler 读取完毕.
     * 执行后会自动跳转到 ChannelPipeline 中的下一个 ChannelHandler.
     *
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //向客户端返回数据,writeAndFlush() 也可以拆分成 write(msg) 和 flush()
        ctx.writeAndFlush(Unpooled.copiedBuffer("见到你，我也很高兴^_^",CharsetUtil.UTF_8));
    }

    /**
     * exceptionCaught()： 在读取操作期间，有异常抛出时会调用。
     *
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 发生异常时关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}

