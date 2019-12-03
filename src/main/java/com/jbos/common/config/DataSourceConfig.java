package com.jbos.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * ActivitiConfig
 * @author youfu.wang
 * @date 2019-01-31
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "default")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.default")
    public DataSource defaultDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "activiti")
    @ConfigurationProperties(prefix = "spring.datasource.druid.activiti")
    public DataSource activitiDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
}
