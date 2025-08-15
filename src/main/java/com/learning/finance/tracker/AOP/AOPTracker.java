package com.learning.finance.tracker.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPTracker {

    @Before("execution(* com.learning.finance.tracker.controller.MainController.*(..))")
    public void logBeforeMethod() {
        System.out.println("AOP: Before");
    }

    @After("execution(* com.learning.finance.tracker.controller.MainController.*(..))")
    public void logAfterMethod() {
        System.out.println("AOP: After");
    }
}
