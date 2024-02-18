package com.trc.tlias.Aop;


import com.alibaba.fastjson.JSONObject;
import com.trc.tlias.Mapper.OperateLogMapper;
import com.trc.tlias.pojo.OperateLog;
import com.trc.tlias.utils.Jwtutils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.trc.tlias.Annotationpkg.Log)")
    public Object AroundLogRecording(ProceedingJoinPoint joinPoint) throws Throwable {

        String token = request.getHeader("token");
        Claims claims = Jwtutils.parseJWT(token);//解析

        Integer operateUser = (Integer)claims.get("id");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = joinPoint.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String methodParams = Arrays.toString(joinPoint.getArgs());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        Long costTime = end - start;
        String returnValue = JSONObject.toJSONString(result);


        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP log日志{}",operateLog);
        return result;
    }
}
