package com.trc.tlias.Aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
//@Aspect
public class MyAspect2 {
    @Pointcut("execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.*(..))")
    private void pointcutDiy(){}

    @Before("pointcutDiy()")
    public void beforeTest(JoinPoint joinPoint){
        log.info("before");
    }

    @Around("pointcutDiy()")
    public Object AroundFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        String classname = joinPoint.getTarget().getClass().getName();
        log.info("classname{}",classname);

        String methodname = joinPoint.getSignature().getName();
        log.info("methodname{}",methodname);

        Object[] args = joinPoint.getArgs();
        log.info("args{}", Arrays.toString(args));

        Object proceed = joinPoint.proceed();
        log.info("proceed{}",proceed);
        return proceed;
    }
}
