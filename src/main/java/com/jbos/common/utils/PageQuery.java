package com.jbos.common.utils;
import com.baomidou.mybatisplus.plugins.Page;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * PageQuery
 * @author youfu.wang
 * @date 2019-02-27
 * @param <T>
 */
public class PageQuery<T> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    public PageQuery(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get("page") != null){
            currPage = Integer.parseInt((String)params.get("page"));
        }
        if(params.get("limit") != null){
            limit = Integer.parseInt((String)params.get("limit"));
        }
        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);
        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);
    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}
