package com.swellwu.config;

import com.swellwu.interceptor.InterceptorOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author swellwu
 * @create 2017-07-13-23:17
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InterceptorOne interceptorOne(){
        return new InterceptorOne("interceptorOne");
    }

    @Bean
    public InterceptorOne interceptorTwo(){
        return new InterceptorOne("interceptorTwo");
    }

    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorOne());
        registry.addInterceptor(interceptorTwo());
    }

}
