package com.jbos;
import com.jbos.common.spring.ApplicationContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class JBOSApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JBOSApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication springApplication=new SpringApplication(JBOSApplication.class);
		springApplication.addListeners(new ApplicationContextListener());
		ApplicationContext applicationContext=springApplication.run(args);
	}

}

