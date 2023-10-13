 package com.example.stationski.configs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class PerformanceAspect {


    @Around("execution(* com.example.stationski.services.*.*(..))")

    public void profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        pjp.proceed(); // lancer la méthode éligible
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
    }

}
