package com.example.demo.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 24431 on 2018/8/9.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//addPathPattern后跟拦截地址，excludePathPatterns后跟排除拦截地址
    registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/page/**").excludePathPatterns("/page/loding");
    }
}
