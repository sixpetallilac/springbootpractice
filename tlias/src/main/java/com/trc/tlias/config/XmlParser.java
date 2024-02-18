package com.trc.tlias.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmlParser {
    @Bean
    public SAXReader saxReader(){
        return new SAXReader();
    }
}
