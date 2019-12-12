package com.jbos.common.redis;

import com.jbos.infrastructure.websecurity.session.SessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * RedisSessionCache
 * @author youfu.wang
 * @date 2019-01-31
 */
@Component
public class RedisSessionCache implements SessionCache{
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void add(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,60*60, TimeUnit.SECONDS);
    }

    @Override
    public void add(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,timeout, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
