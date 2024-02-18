package com.trc.tlias.Interceptor;


import com.alibaba.fastjson.JSONObject;
import com.trc.tlias.pojo.Result;
import com.trc.tlias.utils.Jwtutils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class loginCheckinInteceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String token = request.getHeader("token");
//        if (!StringUtils.hasLength(token)) {
//            log.info("token null");
//            Result notLogin = Result.failed("not_login");
//            String jsonString = JSONObject.toJSONString(notLogin);
//            response.getWriter().write(jsonString);
//            return false;
//        }
//        try {
//            Jwtutils.parseJWT(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("failed login");
//            Result notLogin = Result.failed("not_login");
//            String jsonString = JSONObject.toJSONString(notLogin);
//            response.getWriter().write(jsonString);
//            return false;
//        }
//        log.info("access login");
//        return true;
//    }
@Override //目标资源方法运行前运行, 返回true: 放行, 放回false, 不放行
public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
    //1.获取请求url。
    String url = req.getRequestURL().toString();
    log.info("请求的url: {}",url);

    //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
    if(url.contains("login")){
        log.info("登录操作, 放行...");
        return true;
    }

    //3.获取请求头中的令牌（token）。
    String jwt = req.getHeader("token");

    //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
    if(!StringUtils.hasLength(jwt)){
        log.info("请求头token为空,返回未登录的信息");
        Result error = Result.failed("NOT_LOGIN");
        //手动转换 对象--json --------> 阿里巴巴fastJSON
        String notLogin = JSONObject.toJSONString(error);
        resp.getWriter().write(notLogin);
        return false;
    }

    //5.解析token，如果解析失败，返回错误结果（未登录）。
    try {
        Jwtutils.parseJWT(jwt);
    } catch (Exception e) {//jwt解析失败
        e.printStackTrace();
        log.info("解析令牌失败, 返回未登录错误信息");
        Result error = Result.failed("NOT_LOGIN");
        //手动转换 对象--json --------> 阿里巴巴fastJSON
        String notLogin = JSONObject.toJSONString(error);
        resp.getWriter().write(notLogin);
        return false;
    }

    //6.放行。
    log.info("令牌合法, 放行");
    return true;
}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String token = request.getHeader("token");

        System.out.println("postHandlee");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletionn");
    }
}
