package com.example.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
    private static final Log log = LogFactory.getLog(LoggingAspect.class);
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
     * The modifiers-pattern? (Optional): This specifies method modifiers like public, protected, etc. You can omit this if you want
     * to match any modifier.
     * The ret-type-pattern: This specifies the return type of the method. You can use specific types (e.g., String, int) or
     * wildcards (e.g., * for any return type).
     * The declaring-type-pattern? (Optional): This specifies the class or interface that declares the method. You can use the fully
     * qualified class name or package patterns (e.g., com.example.*).
     * The method-name-pattern: This specifies the name of the method. You can use specific method names or wildcards (e.g., * for
     * any method name).
     * The param-pattern: This specifies the parameters of the method. You can list specific types or use wildcards (e.g., .. for
     * any number of parameters).
     * The throws-pattern? (Optional): This specifies the exceptions thrown by the method. You can omit this if you don't want to
     * match based on thrown exceptions.
     * "execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)"
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

    /*
     * This pointcut expression "execution(* com.example.services.*.*(..)) && args(status,..)" matches the execution of any method
     * within the com.example.services package, where the first argument is named status, and there can be any number of additional
     * arguments.
     *
     * */
    @Before("execution(* com.example.services.*.*(..)) && args(status,..)")
    public void logBefore(JoinPoint joinPoint, String status) {
        System.out.println("logBefore()");
        System.out.println("A method " + joinPoint.getSignature().getName() + " in the service layer is about to be executed.");
        System.out.println("User status passed as a parameter: " + status);
    }

    @Around("execution(* com.example.services.UserService.*(..)) && args(status,..)")
    public Object logAround(ProceedingJoinPoint joinPoint, String status) throws Throwable {
        System.out.println("logAround()");
        System.out.println("A method " + joinPoint.getSignature().getName() + " in the service layer is about to be executed.");
        System.out.println("User status passed as a parameter: " + status);


        /*
         * The joinPoint.proceed() method is called, which executes the original method (e.g., createUser() or getUser() in
         * UserService).
         *
         * Example Scenario:
         * Target Method: Suppose getUser() in UserService returns a User object.
         * Advice: The logAround advice will capture that User object in the "result" variable.
         * */
        var result = joinPoint.proceed();
        if (result != null) System.out.println("Result: " + result);

        System.out.println("A method " + joinPoint.getSignature().getName() + " in the service layer is already executed.");

        /*
         * The Object result ensures that the return value of the original method (e.g., getUser) is passed back to it without
         * alteration, unless you explicitly change it within the advice.
         * */
        return result;
    }

    // This advice is triggered when any join point that matches the pointcut throws an exception.
    @AfterThrowing(pointcut = "execution(* com.example.services.*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("logAfterThrowing()");
        System.out.println("Exception thrown: " + exception.getMessage());
    }

    // This advice is triggered when any join point that matches the pointcut successfully returns void or data type.
    @AfterReturning(pointcut = "execution(* com.example.services.*.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("logAfterReturning()");
        System.out.println("Method returned: " + result);
    }

//    @Pointcut("execution(* com.example.services.UserService.get*(..))")
//    public void getterMethods() {
//    }
//
//    @Before("getterMethods()")
//    public void logBeforeGetterMethods(JoinPoint joinPoint) {
//        System.out.println("A getter method " + joinPoint.getSignature().getName() + " is being called.");
//    }

//    Line 44 to 50 is identical to the advice below:
//    @Before("execution(* com.example.services.UserService.get*(..))")
//    public void logBeforeGetterMethods(JoinPoint joinPoint) {
//        System.out.println("A getter method " + joinPoint.getSignature().getName() + " is being called.");
//    }
}
