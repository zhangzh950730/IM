package com.zzh.im.netty.server;

import com.zzh.im.netty.codec.PacketCodecHandler;
import com.zzh.im.netty.codec.Spliter;
import com.zzh.im.netty.handler.IMIdleStateHandler;
import com.zzh.im.netty.server.handler.AuthHandler;
import com.zzh.im.netty.server.handler.HeartBeatRequestHandler;
import com.zzh.im.netty.server.handler.IMHandler;
import com.zzh.im.netty.server.handler.LoginRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/10 9:48
 */
public class NettyServer {
    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap
                .group(bossGroup, workerGroup)
                // 指定连接类型 NIO/IO
                .channel(NioServerSocketChannel.class)
                //.channel(OioServerSocketChannel.class)

                // 自定义属性
                .attr(AttributeKey.newInstance("serverName"), "nettrServer")
                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                // 一些TCP属性
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 指定服务端启动过程中的逻辑
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) throws Exception {
                        System.out.println("服务端启动中");
                    }
                })
                // 指定新连接数据的读写逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IMIdleStateHandler());
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        ch.pipeline().addLast(IMHandler.INSTANCE);
                    }
                });
        bind(serverBootstrap, 8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口" + port + "绑定成功");
            } else {
                System.out.println("端口" + port + "绑定失败");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
