package ru.kpfu.itis.demo.blog.impl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {
//    @Pointcut("execution(public * ru.kpfu.itis.demo.blog.impl.service.TestAopService.*(..))")
//    public void aopServicePointcut(){}

    @Before("@annotation(DemoBefore)")
    public void beforeAnnotation(JoinPoint joinPoint){
        System.out.println("executing method = " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
//
//    @Before("aopServicePointcut()")
//    public void beforeAop(){
//        System.out.println("Before");
//    }
//
//    @After("aopServicePointcut()")
//    public void afterAop(){
//        System.out.println("After");
//    }
//
//    @AfterReturning(value = "aopServicePointcut()", returning = "result")
//    public void afterReturning(Object result){
//        System.out.println("Method return = " + result);
//    }
//
//    @Around("aopServicePointcut()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Around Before");
//        Object proceed = joinPoint.proceed();
//        System.out.println("Around After");
//        return proceed;
//    }
}
