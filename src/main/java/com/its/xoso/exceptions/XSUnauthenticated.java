package com.its.xoso.exceptions;

import org.springframework.http.HttpStatus;

public class XSUnauthenticated extends RuntimeException {

    private HttpStatus status = HttpStatus.UNAUTHORIZED;
    public XSUnauthenticated(String message) {
        super(message);
        this.status = HttpStatus.UNAUTHORIZED;
    }

    public XSUnauthenticated(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
