package org.project;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.project.ShoppingCart.checkout(..))")
    //@Before("execution(* checkout())")
    public void beforeLogger(JoinPoint jp) {
        String arg = jp.getArgs()[0].toString();
        System.out.println("Before Loggers with argument: " + arg);
    }

    @After("execution(* org.project.ShoppingCart.checkout(..))")
    //@After("execution(* checkout())")
    //@After("execution(* *.*.checkout())")
    //(* *.*.checkout()) = (AnyReturnType AnyPackage.AnyClass.Method())
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* org.project.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After returning : " + retVal);
    }
}
