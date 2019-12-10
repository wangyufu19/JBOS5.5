package com.jbos.common.websecurity.session;

/**
 * SessionCache
 * @author youfu.wang
 * @date 2019-10-28
 */
public interface SessionCache {
    /**
     * 添加会话缓存
     * @param key
     * @param value
     */
    public void add(String key,String value);
    /**
     * 添加会话缓存
     * @param key
     * @param value
     * @param timeout
     */
    public void add(String key,String value,long timeout);

    /**
     * 得到会话缓存
     * @param key
     * @return
     */
    public Object get(String key);

    /**
     * 删除会话缓存
     * @param key
     */
    public void delete(String key);
}
