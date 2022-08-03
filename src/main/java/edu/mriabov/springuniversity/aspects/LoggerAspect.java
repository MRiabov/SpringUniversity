package edu.mriabov.springuniversity.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    @Around("execution(* edu.mriabov.springuniversity..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        log.info("Time to execute "+ joinPoint.getSignature().toString() + ": " + Duration.between(Instant.now(), start));
        log.info(joinPoint.getSignature().toString()+" method executed");
        return result;
    }

    @AfterThrowing(value = "execution(* edu.mriabov.springuniversity..*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex){
        log.error(joinPoint.getSignature()+ " threw "+ex.getMessage());
    }
}
