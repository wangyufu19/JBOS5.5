package com.jbos.common.redis;
import java.util.concurrent.TimeUnit;

import com.jbos.common.utils.JsonUtils;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * RedisService
 * @author youfu.wag
 * @daate 2019-02-02
 */
public class RedisService {
    private RedisTemplate redisTemplate;

    /**  默认过期时长60分钟，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 ;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1;
    private long expire=DEFAULT_EXPIRE;

    /**
     * 构造方法
     * @param redisTemplate
     */
    public RedisService(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }



    public void set(String key, Object value, long expire){
        this.redisTemplate.opsForValue().set(key, JsonUtils.toJson(value));
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        Object value = this.redisTemplate.opsForValue().get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : JsonUtils.fromJson(String.valueOf(value), clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public Object get(String key, long expire) {
        Object value = this.redisTemplate.opsForValue().get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public Object get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
