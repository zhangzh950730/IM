package com.zzh.im.netty.client.handler;

import com.zzh.im.netty.protocol.packet.hearbeat.HearBeatRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 14:34
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {
    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartBeat(ctx);
        super.channelActive(ctx);
    }

    private void scheduleSendHeartBeat(ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            ctx.writeAndFlush(new HearBeatRequestPacket());
            scheduleSendHeartBeat(ctx);
        }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }
}
