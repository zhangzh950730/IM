package com.zzh.im.netty.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/11 21:30
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
