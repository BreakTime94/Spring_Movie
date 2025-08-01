package com.climbjava.mreview.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Aspect
@Log4j2
@Controller
public class LogAspect {
  @Before("execution(* *..*.ReviewController.*(..))")
  public void before(JoinPoint joinPoint) {
    log.info("=================================" + joinPoint.getSignature().getName()); // 메서드 선언부를 signature라고 함
    Arrays.stream(joinPoint.getArgs()).forEach(log :: info);
  }
}
