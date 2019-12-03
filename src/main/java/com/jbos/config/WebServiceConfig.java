package com.jbos.config;

import com.jbos.interfaces.webservice.UserService;
import com.jbos.interfaces.webservice.impl.UserServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * WebServiceConfig
 * @author youfu.wang
 * @date 2019-10-28
 */
@Configuration
public class WebServiceConfig {
    @Value("${jbos.webservice.cxf.urlMappings}")
    private String urlMappings;
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new CXFServlet(),urlMappings);
    }
    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    @Bean
    public Endpoint endpoint(){
        Endpoint endpoint=new EndpointImpl(springBus(),userService());
        endpoint.publish("/UserService");
        return endpoint;
    }
}
