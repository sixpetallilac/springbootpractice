package com.trc.tlias.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//@Order(0)
@Slf4j
//@Aspect
@Component
public class MyAspect1 {
//   @Pointcut("execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.deptSelect(..))||execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.deptIns(..))")
//   public void pointcutfunction(){}
    @Pointcut("@annotation(com.trc.tlias.Aop.PointcutAnnotation)")
    public void pointcutfunction(){}
    @Before("pointcutfunction() ")
    public void beforeDiynameTest(){
        log.info("before log  select//ins test");
    }
    @Around("pointcutfunction()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around");
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

    @After("execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.*(..))")
    public void After(){
        log.info("After");
    }

    @AfterReturning("execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.*(..))")
    public void AfterReturning(){
        log.info("AfterReturning");
    }

    @AfterThrowing("execution(* com.trc.tlias.Service.serviceImpl.DeptImplSevice.*(..))")
    public void AfterThrowing() throws Throwable {
        log.info("AfterThrowing");
    }
}
