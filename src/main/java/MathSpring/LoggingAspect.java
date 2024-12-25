package MathSpring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Логирование перед вызовом метода
    @Before("execution(* MathSpring.MathService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Перед вызовом метода: " + methodName);
    }

    // Логирование после успешного завершения метода
    @AfterReturning(pointcut = "execution(* MathSpring.MathService.*(..))",
    returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Метод " + methodName + " вернул: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.demo.service.MathService.*(..))",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Метод " + methodName + " вернул exception: " + e.getMessage());
    }

















}
