package com.service.config;

import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.core.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.geowarin.rest");
        register(LoggingFilter.class);
    }
}
