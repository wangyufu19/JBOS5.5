package com.jbos.common.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 分页插件
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.jbos.app.*.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}