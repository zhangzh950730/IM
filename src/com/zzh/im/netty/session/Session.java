package com.zzh.im.netty.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/11 10:35
 */
@Data
@NoArgsConstructor
public class Session {
    private String userId;
    private String username;

    public Session(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    @Override
    public String toString() {
        return userId + " : " + username;
    }
}
