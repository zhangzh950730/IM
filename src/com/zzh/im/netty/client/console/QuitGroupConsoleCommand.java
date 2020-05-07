package com.zzh.im.netty.client.console;

import com.zzh.im.netty.protocol.packet.group.QuitGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/12 9:35
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();
        System.out.print("输入 groupId，退出群聊：");
        quitGroupRequestPacket.setGroupId(scanner.next());
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
