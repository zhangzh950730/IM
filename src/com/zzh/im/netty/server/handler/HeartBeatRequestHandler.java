package com.zzh.im.netty.server.handler;

import com.zzh.im.netty.protocol.packet.hearbeat.HearBeatRequestPacket;
import com.zzh.im.netty.protocol.packet.hearbeat.HearBeatResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 14:41
 */
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HearBeatRequestPacket> {
    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

    private HeartBeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HearBeatRequestPacket hearBeatRequestPacket) throws Exception {
        ctx.writeAndFlush(new HearBeatResponsePacket());
    }
}
