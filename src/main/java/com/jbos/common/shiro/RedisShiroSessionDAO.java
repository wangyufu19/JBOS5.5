package com.jbos.common.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * RedisShiroSessionDAO
 * @@author youfu.wang
 * @date 2019-10-28
 */
@Component
public class RedisShiroSessionDAO extends EnterpriseCacheSessionDAO {
    @Autowired
    private RedisTemplate redisTemplate;

    public String getSessionKey(String key){
        return "sessionid:" + key;
    }
    //创建session
    @Override
    protected Serializable doCreate(Session session) {

        Serializable sessionId = super.doCreate(session);
        final String key = getSessionKey(sessionId.toString());
        setShiroSession(key, session);
        return sessionId;
    }

    //获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {


        Session session = super.doReadSession(sessionId);
        if(session == null){
            final String key = getSessionKey(sessionId.toString());
            session = getShiroSession(key);
        }

        return session;
    }

    //更新session
    @Override
    protected void doUpdate(Session session) {

        super.doUpdate(session);
        final String key = getSessionKey(session.getId().toString());
        setShiroSession(key, session);
    }

    //删除session
    @Override
    protected void doDelete(Session session) {

        super.doDelete(session);
        final String key = getSessionKey(session.getId().toString());
        redisTemplate.delete(key);
    }

    private Session getShiroSession(String key) {
        return (Session)redisTemplate.opsForValue().get(key);

    }

    private void setShiroSession(String key, Session session){
        redisTemplate.opsForValue().set(key, session);
        //60分钟过期
        redisTemplate.expire(key, 60, TimeUnit.MINUTES);

    }
}
