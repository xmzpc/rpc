package com.xmzpc.protocol.dubbo;

import com.xmzpc.framework.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private Invocation invocation;
    private String result;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();
    }

    public synchronized Object call() throws Exception {
        context.writeAndFlush(this.invocation);
        wait();
        return result;
    }

    public void setInvocation(Invocation invocation) {
        this.invocation = invocation;
    }
}
