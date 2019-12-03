package com.jbos.common.redis;

/**
 * RedisKey
 * @author youfu.wang
 * @date 2019-02-02
 */
public class RedisKey {
    public static String getConfigKey(String key){
        return "config:" + key;
    }

    public static String getSessionKey(String key){
        return "sessionid:" + key;
    }
}
