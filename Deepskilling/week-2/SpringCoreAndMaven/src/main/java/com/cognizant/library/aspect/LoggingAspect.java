package com.cognizant.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Run the target service method
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("AOP Logger: [ " + joinPoint.getSignature().toShortString() + 
                           " ] executed in " + executionTime + " ms.");
        
        return proceed;
    }
}