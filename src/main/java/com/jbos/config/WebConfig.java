package com.jbos.config;
import com.jbos.infrastructure.websecurity.WebSecurityFilter;
import com.jbos.infrastructure.websecurity.WebSecurityManager;
import com.jbos.infrastructure.websecurity.auth.Authentication;
import com.jbos.infrastructure.websecurity.session.SessionCache;
import com.jbos.infrastructure.websecurity.session.SessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVCConfig
 * @author youfu.wang
 * @date 2019-01-31
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${jbos.websecurity.loginUrl}")
    private String loginUrl;
    @Value("${jbos.websecurity.excludeUrlPatterns}")
    private String excludeUrlPatterns;
    @Value("${jbos.websecurity.sessionTimeout}")
    private int sessionTimeout;
    @Value("${jbos.websecurity.enableCache}")
    private boolean enableCache;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
    }
    @Bean
    public SessionManager sessionManager(SessionCache sessionCache){
        SessionManager sessionManager=new SessionManager();
        sessionManager.setSessionTimeout(sessionTimeout);
        sessionManager.setEnableCache(enableCache);
        sessionManager.setSessionCache(sessionCache);
        return sessionManager;
    }
    @Bean
    public WebSecurityManager webSecurityManager(SessionManager sessionManager, Authentication authentication){
        WebSecurityManager webSecurityManager=new WebSecurityManager();
        webSecurityManager.setSessionManager(sessionManager);
        webSecurityManager.setAuthentication(authentication);
        return webSecurityManager;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(WebSecurityManager webSecurityManager){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        WebSecurityFilter webSecurityFilter=new WebSecurityFilter();
        webSecurityFilter.setWebSecurityManager(webSecurityManager);
        registrationBean.setName("webFilter");
        registrationBean.setFilter(webSecurityFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("loginUrl",loginUrl);
        registrationBean.addInitParameter("excludeUrlPatterns",excludeUrlPatterns);
        return registrationBean;
    }
}
