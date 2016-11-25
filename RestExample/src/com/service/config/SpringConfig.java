package com.service.config;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import lombok.Data;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class SpringConfig {

    private String username = "isakalinsaz";
    private String password = "Test1234";

    @Bean
    public SpringConfig getConfig() {
        return new SpringConfig();
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        // our rest resources will be available in the path /rest/*
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }
}
