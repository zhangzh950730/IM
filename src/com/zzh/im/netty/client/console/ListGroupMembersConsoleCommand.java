package com.zzh.im.netty.client.console;

import com.zzh.im.netty.protocol.packet.group.ListGroupMembersRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 9:43
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket = new ListGroupMembersRequestPacket();
        System.out.print("输入 groupId，获取群成员列表：");
        listGroupMembersRequestPacket.setGroupId(scanner.next());
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
