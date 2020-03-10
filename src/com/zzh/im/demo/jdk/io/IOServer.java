package com.zzh.im.demo.jdk.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/8 16:14
 */
public class IOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        // 接受新连接线程
        new Thread(() -> {
            try {
                // 阻塞方法获取新连接
                Socket socket = serverSocket.accept();
                // 每一个新的连接都创建一个线程,负责读取数据
                new Thread(() -> {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        byte[] data = new byte[1024];
                        int len;
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
