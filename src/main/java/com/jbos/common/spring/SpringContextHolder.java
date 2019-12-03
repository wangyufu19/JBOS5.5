package com.jbos.common.spring;

import org.springframework.context.ApplicationContext;

/**
 * SpringContextHolder
 * @author youfu.wang
 * @date 2019-10-28
 */
public class SpringContextHolder {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext){
        SpringContextHolder.applicationContext=applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
