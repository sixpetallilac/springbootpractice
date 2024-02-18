package com.trc.tlias;

import com.trc.tlias.controller.deptController;
import com.trc.tlias.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.print.Doc;
import java.util.*;

@SpringBootTest
class TliasApplicationTests {

    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        for (int i = 0;i < 1000; i++){
            String string = UUID.randomUUID().toString();
            System.out.println(string);
        }
    }

    @Test
    void TestFunction(){
        Map<String,Object> keyvalue = new HashMap<>();
        keyvalue.put("id",1);
        keyvalue.put("name ","tom");

        String defaultmessage = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "defaultmessage")//header
                .setClaims(keyvalue)//payload
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))//令牌有效期 ms*1000=s
                .compact();
        System.out.println(defaultmessage);

    }
    @Test
    void ParseFunction(){
        Claims test = Jwts.parser()
                .setSigningKey("defaultmessage")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzA2MzUzMjEzLCJuYW1lICI6InRvbSJ9.k_6Qp5WNj24lgWcT41ZsoTIoC6oq7Y4XsuSPHbPe1Ko")
                .getBody();
        System.out.println(test);
    }
    @Test
    void leetcode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("input:");
        String[] s = sc.nextLine().split(" ");
        System.out.println(s[s.length-1].length());
    }

    @Test
    public void test(){
        deptController dc = (deptController)applicationContext.getBean("deptController");
        deptController bean = applicationContext.getBean(deptController.class);
        applicationContext.getBean("deptcontroller", deptController.class);

    }

    @Autowired
    private SAXReader saxReader;
    @Test
    public void xmlParse() throws DocumentException {
        Document read = saxReader.read(this.getClass().getClassLoader().getResource("static/aaa.xml"));
        Element rootElement = read.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();
        System.out.println(name + "  "+age);
    }
}
