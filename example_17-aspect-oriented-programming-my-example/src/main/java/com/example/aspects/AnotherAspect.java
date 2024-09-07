package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AnotherAspect {
    /*
     * If multiple identical advices need to be applied to a single pointcut, we can specify the execution order of these aspects.
     *
     * The @Order annotation defines the sorting order of an annotated component or bean.
     *
     * The LoggingAspect class will run first because it is annotated with @Order(1). In contrast, by default, without the @Order
     * annotation, the AnotherAspect class will run first before the LoggingAspect class.
     * */
    @Before("execution(* com.example.services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() from AnotherAspect");
    }
}
