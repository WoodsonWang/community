package com.woodson.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired(required = false)
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        /**拦截所有网页
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}
