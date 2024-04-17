package com.its.xoso.exceptions.advice;


import com.google.common.collect.Maps;
import com.its.xoso.exceptions.XSUnauthenticated;
import com.its.xoso.exceptions.XSBusinessException;
import com.its.xoso.response.XSResponseDto;
import io.sentry.Sentry;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@Log4j2
@RestControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(XSBusinessException.class)
    public ResponseEntity handleBusinessException(XSBusinessException exc) {
        log.error("handleBusinessException: {}", exc.getMessage());
        Sentry.captureException(exc);
        return XSResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(exc.getStatus())
                .withMessage(exc.getMessage())
                .toResponseEntity();
    }

    @ExceptionHandler(XSUnauthenticated.class)
    public ResponseEntity handleBusinessException(XSUnauthenticated exc) {
        log.error("handleBusinessException:", exc);
        Sentry.captureException(exc);
        return XSResponseDto.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.UNAUTHORIZED)
                .withMessage(exc.getMessage())
                .toResponseEntity();
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logger.info(ex.getClass().getName());
        Map<String, Object> errors = Maps.newConcurrentMap();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }
        log.error(errors);
        Sentry.captureException(ex);
        return XSResponseDto
                .build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage("Thông tin đầu vào không chính xác")
                .withErrors(errors).withHttpHeaders(headers).toResponseEntity();
    }
}
