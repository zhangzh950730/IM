package com.zzh.im.netty.protocol.packet.message;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 10:52
 */
@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
