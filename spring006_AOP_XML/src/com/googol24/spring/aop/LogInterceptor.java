package com.googol24.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect// 切面逻辑类
@Component//Aspect需要声明为组件，便于初始化为组件给Spring管理
/**
 * You may register aspect classes as regular beans in your Spring XML configuration, or autodetect them
 * through classpath scanning - just like any other Spring-managed bean.
 * However, note that the @Aspect annotation is not sufficient for autodetection in the classpath: For that purpose,
 * you need to add a separate @Component annotation (or alternatively a custom stereotype annotation that qualifies, as per the rules of Spring's component scanner).
 *
 * 您可以在Spring XML配置中注册aspect类，或者通过类路径扫描自动检测它们，就像任何其他Spring管理bean一样。但是，请注意，@aspect注解对于在类路径中自动检测是不够的。
 * 为了达到这个目的，您需要添加一个单独的@component注解（或者根据Spring的组件扫描器的规则来定义一个定制的原型注解）
 */
public class LogInterceptor {
    // PointCut
    // 表示匹配com.googol24.spring.dao包下面的或者其子包下面的任意返回类型的所有方法
//    @Pointcut("execution(public * com.googol24.spring.service..*.*(..))") // PointCut表达式
    public void pcMethod(){} // PointCut签名

    // 切入点语法
    // 在方法执行之前先执行
//    @Before("execution(public void com.googol24.spring.dao.UserDAODB2.save(com.googol24.spring.model.User))")
    public void before() {
        System.out.println("method start......");
    }

//    @After("execution(public void com.googol24.spring.dao.UserDAODB2.save(com.googol24.spring.model.User))")
    public void after() {
        System.out.println("method end......");
    }

//    @AfterReturning("execution(public * com.googol24.spring.dao..*.*(..))")
//    @AfterReturning("pcMethod()")
    public void afterReturning() {
        System.out.println("method after returning------");
    }

//    @Around("pcMethod()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around start......");
        proceedingJoinPoint.proceed();
        System.out.println("around end");
    }
}
