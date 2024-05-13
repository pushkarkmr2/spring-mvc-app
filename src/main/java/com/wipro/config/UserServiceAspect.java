package com.wipro.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    private static final Logger log = LoggerFactory.getLogger(UserServiceAspect.class);

    @Before(value = "execution(* com.wipro.service..*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
       log.info("This is printing before advice");
    }

    @After(value = "execution(* com.wipro.service..*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        log.info("This is printing after advice");
    }

    @Around(value = "execution(* com.wipro.service..*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        log.info("This is printing before around advice");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        log.info("This is printing after around advice");
    return value;
    }


}
