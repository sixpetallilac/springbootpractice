package com.trc.tlias;

import com.example.HeaderConfig;
import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.trc.tlias.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class AutoConfigurationTest {
    @Autowired
    private Gson gson;
    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void testJson(){
        String json = gson.toJson(Result.success());
        System.out.println(json);
    }
    @Test
    public void testTokenParser(){
        System.out.println(applicationContext.getBean(HeaderParser.class));
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }

}
