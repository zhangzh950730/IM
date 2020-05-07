package com.zzh.im.netty.protocol.packet.message;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import lombok.Data;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/10 15:51
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;
    private String fromUsername;
    private String message;
    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
