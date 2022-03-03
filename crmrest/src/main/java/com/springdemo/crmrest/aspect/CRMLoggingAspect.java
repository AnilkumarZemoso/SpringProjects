package com.springdemo.crmrest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springhibernate.crm.controller.*.*(..))")
    public void forController(){}

    @Pointcut("execution(* com.springhibernate.crm.service.*.*(..))")
    public void forService(){}

    @Pointcut("execution(* com.springhibernate.crm.dao.*.*(..))")
    public void forDAO(){}

    @Pointcut("forController() || forService() || forDAO()")
    public void forAppFlow(){}

    @Before("forAppFlow()")
    public void beforeMethod(JoinPoint theJoinPoint) {
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("@Before the method:"+method);

        Object[] args=theJoinPoint.getArgs();
        for(Object tempArg:args) {
            myLogger.info("argument: "+tempArg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("@After the method: "+method);
        myLogger.info("result :"+theResult);
    }
}
