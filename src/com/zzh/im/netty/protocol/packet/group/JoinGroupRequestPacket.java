package com.zzh.im.netty.protocol.packet.group;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import lombok.Data;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 9:20
 */
@Data
public class JoinGroupRequestPacket extends Packet {
    private String groupId;


    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_REQUEST;
    }
}
