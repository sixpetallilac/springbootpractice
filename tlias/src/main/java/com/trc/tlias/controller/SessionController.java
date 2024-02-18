package com.trc.tlias.controller;

import com.trc.tlias.pojo.Result;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("testname","value"));
        return Result.success();
    }
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("testname")){
                System.out.println(c.getName()+" "+c.getValue());
            }
        }
        return Result.success();
    }

    @GetMapping("/s1")
    public Result session1(HttpSession session){
        
        log.info("httpsession-s1 {}",session.hashCode());
        session.setAttribute("loginuser","valueset");//-1
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request){
        HttpSession session = request.getSession();//-1
        log.info("httpsession-s2 {}",session.hashCode());

        Object loginuser = session.getAttribute("loginuser");//-1
        log.info("loginuser  {}",loginuser);

        return Result.success(loginuser);
    }
}
