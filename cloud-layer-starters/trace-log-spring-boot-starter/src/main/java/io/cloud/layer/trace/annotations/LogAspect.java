package io.cloud.layer.trace.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author RippleChan
 * @date 2019-05-26 13:07
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut(value = "@annotation(Trace)")
    public void trace() {

    }

    @Around(value = "io.cloud.layer.trace.annotations.LogAspect.trace()")
    public void around(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
    }

}
