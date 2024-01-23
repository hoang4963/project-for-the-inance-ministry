package com.its.karaoke.response;

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
public class KaraEContractDto<T> {
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

    public static <T> KaraEContractDto<T> build() {
        return new KaraEContractDto<>();
    }

    @PostConstruct
    private void init() {
        httpStatus = HttpStatus.OK;
        status = httpStatus.value();
        success = true;
        errors = Maps.newConcurrentMap();
    }

    public KaraEContractDto<T> withHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        return this;
    }

    public KaraEContractDto<T> withStatus(int code) {
        this.status = code;
        return this;
    }

    public KaraEContractDto<T> withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public KaraEContractDto<T> withData(T data) {
        this.data = data;
        return this;
    }

    public KaraEContractDto<T> withHttpHeaders(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
        return this;
    }

    public KaraEContractDto<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public KaraEContractDto<T> withErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseEntity<KaraEContractDto> toResponseEntity() {
        return new ResponseEntity<>(this, headers, httpStatus);
    }
}
