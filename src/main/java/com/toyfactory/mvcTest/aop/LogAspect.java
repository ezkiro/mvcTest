package com.toyfactory.mvcTest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("@annotation(com.toyfactory.mvcTest.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("[aop] start");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = pjp.proceed();

        stopWatch.stop();
        log.debug("[aop] execution time:{} ms", stopWatch.getTotalTimeMillis());
        return proceed;
    }
}
