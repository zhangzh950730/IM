package com.zzh.im.netty.serializer;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/3/10 14:47
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * Java对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成Java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

}
