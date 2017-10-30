package com.david.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by zhanghewei on 17/9/25.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger =  LoggerFactory.getLogger(HttpAspect.class);


    //公用方法 使用Pointcut注解
    @Pointcut("execution(public * com.david.controller.GirlController.*(..))")
    public void log(){
        System.out.println("before");
    }

    //在方法执行之前执行
    @Before("log()")
    public void before(JoinPoint joinpoint){
        logger.info("onbefore");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("url={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法:类名+方法名
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName() + "_" +joinpoint.getSignature().getName());
        //参数
        logger.info("params={}",joinpoint.getArgs());
    }

    //在方法执行之后执行
    @After("log()")
    public void after(){
        logger.info("after");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturninig(Object object){
        logger.info("response={}",object.toString());
    }


}
