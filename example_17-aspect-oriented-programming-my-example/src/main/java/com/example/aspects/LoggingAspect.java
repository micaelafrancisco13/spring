package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    /*
     * 1. ASPECT
     *
     * An aspect is a modularization of a cross-cutting concern, which is a functionality that affects multiple parts of an
     * application. Common cross-cutting concerns include logging, transaction management, and security.
     * In Spring, aspects can be implemented using classes annotated with @Aspect.
     *
     * 2. JOIN POINT
     *
     * A point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP,
     * a join point always represents a method execution.
     * Here, the join point is the method execution that matches the pointcut expression.
     *
     * 3. ADVICE
     *
     * Advice is the action taken by an aspect at a particular join point. It defines what should happen at the join point (e.g.,
     * before a method is executed, after it returns, or around its execution).
     * logBefore(): This is a before advice. It is executed before the join point (i.e., before the createUser and getUser methods
     * are executed).
     *
     * 4. POINTCUT
     *
     * A predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by
     * the pointcut (for example, the execution of a method with a certain name).
     * The expression "execution(* com.example.services.*.*(..))" is a pointcut expression.
     *
     * 5. INTRODUCTION
     *
     *
     * 6. TARGET OBJECT
     *
     * The target object is the object being advised by one or more aspects. In Spring AOP, the target object is always proxied,
     * meaning it’s wrapped by a proxy object that applies the advice.
     *
     * 7. AOP PROXY
     *
     * An object created by the AOP framework to implement the aspect contracts (advice method executions and so on).
     *
     * 8. WEAVING
     *
     * Weaving is the process of linking aspects with other application types or objects to create an advised object. In Spring
     * AOP, weaving is done at runtime.
     * In Spring, when the application context is started, Spring scans for aspects and applies them to the target objects by
     * creating proxies. This weaving process happens at runtime, as opposed to compile-time or load-time weaving used in other
     * AOP frameworks like AspectJ.
     * By enabling @EnableAspectJAutoProxy, Spring automatically performs runtime weaving, applying aspects to your beans.
     *
     * */

    @Before("execution(* com.example.services.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("A method in the service layer is about to be executed.");
    }

    @Pointcut("execution(* com.example.services.UserService.get*(..))")
    public void getterMethods() {}

    @Before("getterMethods()")
    public void logBeforeGetterMethods() {
        System.out.println("A getter method is being called.");
    }

    // Line 44 to 50 is identical to the advice below:
//    @Before("execution(* com.example.services.UserService.get*(..))")
//    public void logBeforeGetterMethods() {
//        System.out.println("A getter method is being called.");
//    }
}
