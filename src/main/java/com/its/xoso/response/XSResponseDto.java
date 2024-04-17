package com.its.xoso.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Maps;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Map;

@Log4j2
@Setter
@Getter
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class XSResponseDto<T> {
    @JsonIgnore
    private HttpStatus httpStatus = HttpStatus.OK;

    @JsonIgnore
    private HttpHeaders headers;

    private int status = HttpStatus.OK.value();

    private boolean success = true;

    private String message;

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> errors;

    public static <T> XSResponseDto<T> build() {
        return new XSResponseDto<>();
    }

    @PostConstruct
    private void init() {
        httpStatus = HttpStatus.OK;
        status = httpStatus.value();
        success = true;
        errors = Maps.newConcurrentMap();
    }

    public XSResponseDto<T> withHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        return this;
    }

    public XSResponseDto<T> withStatus(int code) {
        this.status = code;
        return this;
    }

    public XSResponseDto<T> withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public XSResponseDto<T> withData(T data) {
        this.data = data;
        return this;
    }

    public XSResponseDto<T> withHttpHeaders(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
        return this;
    }

    public XSResponseDto<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public XSResponseDto<T> withErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseEntity<XSResponseDto> toResponseEntity() {
        return new ResponseEntity<>(this, headers, httpStatus);
    }
}
