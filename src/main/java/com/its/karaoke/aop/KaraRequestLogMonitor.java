package com.its.karaoke.aop;

import com.its.karaoke.utils.KaraDateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class KaraRequestLogMonitor {
    private static final Logger LOGGER = LogManager.getLogger(KaraRequestLogMonitor.class);


    @Pointcut("@annotation(KaraSpecialLog)")
    public void specialLog() {
    }

    @Around("@annotation(KaraSpecialLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        KaraSpecialLog specialLog = method.getAnnotation(KaraSpecialLog.class);
        //before
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        long startTime = KaraDateUtils.currentTimeMillis();
        LOGGER.info("{} execute with method = {} start: {}", clazz, method.getName(), startTime);
        //start method execution
        boolean showResults = specialLog != null && specialLog.isEnabled();
        if (showResults) {
            Object[] params = proceedingJoinPoint.getArgs();
            LOGGER.info("{}", params);
        }
        Object result = proceedingJoinPoint.proceed();
        //show after
        long endTime = System.currentTimeMillis();
        LOGGER.info("{} execute with method = {} end: {} duration: {}", clazz, method.getName(), endTime, endTime - startTime);
        return result;
    }

    @AfterReturning(pointcut = "specialLog()", returning = "returnValue")
    public void returnObject(JoinPoint joinPoint, Object returnValue) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        KaraSpecialLog loggableMethod = method.getAnnotation(KaraSpecialLog.class);
        if (returnValue != null) {
            boolean showResults = loggableMethod != null && loggableMethod.isEnabled();
            if (showResults) {
                if (returnValue instanceof ResponseEntity) {
                    ResponseEntity rs = (ResponseEntity) returnValue;
                    LOGGER.info("[{}] Response -> {}", methodName, rs.getBody());
                }
            }
        }
    }
}

