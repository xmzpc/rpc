package com.xmzpc.protocol.dubbo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * ********书山有路勤为径*********
 * Desciption:
 * Author: XMZPC.
 * Creation time: 2019/10/22 14:38:00.
 * *******学海无涯苦作舟*********
 */
public class NettyServer {

    public void start(String hostName, int port) {
        try {
            final ServerBootstrap bootstrap = new ServerBootstrap();
            NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
            bootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder", new ObjectDecoder(ClassResolvers
                                    .weakCachingConcurrentResolver(this.getClass()
                                            .getClassLoader())));
                            pipeline.addLast("encoder", new ObjectEncoder());
                            pipeline.addLast("handler", new NettyServerHandler());
                        }
                    });
            bootstrap.bind(hostName, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {

    }
}
