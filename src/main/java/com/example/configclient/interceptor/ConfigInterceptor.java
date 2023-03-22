package com.example.configclient.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
@RequiredArgsConstructor
public class ConfigInterceptor extends WebMvcConfigurerAdapter {

    private final InterceptorClass interceptorClass;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorClass);
    }
}
