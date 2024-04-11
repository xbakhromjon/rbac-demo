package com.xbakhromjon.rbacdemo.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorRegisterer implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor candidate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(candidate);
    }
}
