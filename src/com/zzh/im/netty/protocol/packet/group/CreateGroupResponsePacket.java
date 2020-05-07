package com.zzh.im.netty.protocol.packet.group;

import com.zzh.im.netty.protocol.Command;
import com.zzh.im.netty.protocol.packet.Packet;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/11 21:41
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;
    private String groupId;
    private List<String> usernameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
