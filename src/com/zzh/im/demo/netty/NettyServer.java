package com.zzh.im.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/8 17:42
 */
public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new ChannelInboundHandlerA());
                        ch.pipeline().addLast(new ChannelInboundHandlerB());
                        ch.pipeline().addLast(new ChannelInboundHandlerC());

                        ch.pipeline().addLast(new ChannelOutboundHandlerA());
                        ch.pipeline().addLast(new ChannelOutboundHandlerB());
                        ch.pipeline().addLast(new ChannelOutboundHandlerC());
                    }
                })
                .bind(8000);
    }
}
