package com.zzh.im.netty.protocol.packet.hearbeat;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 14:42
 */
public class HearBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }

}
