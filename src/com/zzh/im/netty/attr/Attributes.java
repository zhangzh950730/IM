package com.zzh.im.netty.attr;

import com.zzh.im.netty.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/10 15:54
 */
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
