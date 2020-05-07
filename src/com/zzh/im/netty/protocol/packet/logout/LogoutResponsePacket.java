package com.zzh.im.netty.protocol.packet.logout;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import lombok.Data;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/11 21:44
 */
@Data
public class LogoutResponsePacket extends Packet {
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return Command.LOGOUT_RESPONSE;
    }
}
