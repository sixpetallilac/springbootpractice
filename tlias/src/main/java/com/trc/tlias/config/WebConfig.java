package com.trc.tlias.config;

import com.trc.tlias.Interceptor.loginCheckinInteceptor;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private loginCheckinInteceptor loginCheckinter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //可以add拦截目录/** all /*一级目录 也可以exclude目录
        registry.addInterceptor(loginCheckinter).addPathPatterns("/**").excludePathPatterns("/login");
    }


}
