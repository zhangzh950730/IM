package com.zzh.im.netty.protocol.packet.message;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import com.zzh.im.netty.session.Session;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 11:09
 */
@Data
@NoArgsConstructor
public class GroupMessageResponsePacket extends Packet {
    private String fromGroupId;
    private Session fromUser;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
