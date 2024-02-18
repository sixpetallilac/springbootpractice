package com.trc.tlias.Filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.trc.tlias.pojo.Result;
import com.trc.tlias.utils.Jwtutils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@Slf4j
public class FilterDemo implements Filter {
    @Override//one
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override//much
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURL = request.getRequestURL().toString();//getting url

//判断是否是登录界面
        if (requestURL.contains("login")) {//if having login
            log.info("放行..........");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
//请求头

        String token = request.getHeader("token");
        //在 Web 开发中，使用 token 作为身份验证令牌的名称是一种常见的做法

//判断是否为null null拒绝login
        if (!StringUtils.hasLength(token)) {
            log.info("token null");
            Result notLogin = Result.failed("not_login");
            String jsonString = JSONObject.toJSONString(notLogin);
            response.getWriter().write(jsonString);
            return;
        }
//解析token

        try {
            Jwtutils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();

            log.info("failed login");
            Result notLogin = Result.failed("not_login");
            String jsonString = JSONObject.toJSONString(notLogin);
            response.getWriter().write(jsonString);
        }
        log.info("access login");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override//one
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy");
    }
}
