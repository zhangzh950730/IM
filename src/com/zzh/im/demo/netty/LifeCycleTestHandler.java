package com.zzh.im.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/11 9:20
 */
public class LifeCycleTestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.handlerAdded" + "逻辑处理器被添加");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.channelRegistered" + "channel绑定到线程(NioEventLoop)");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.channelActive" + "channel准备就绪");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("LifeCycleTestHandler.channelRead" + "channel有数据可读");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.channelReadComplete" + "channel某次数据读完");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.channelInactive" + "channel被关闭");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.channelUnregistered" + "channel取消线程(NioEventLoop)的绑定");
        super.channelUnregistered(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LifeCycleTestHandler.handlerRemoved" + "逻辑处理器被移除");
        super.handlerRemoved(ctx);
    }
}
