package com.its.karaoke.exceptions;

import org.springframework.http.HttpStatus;

public class KaraUnauthenticated extends RuntimeException {

    private HttpStatus status = HttpStatus.UNAUTHORIZED;
    public KaraUnauthenticated(String message) {
        super(message);
        this.status = HttpStatus.UNAUTHORIZED;
    }

    public KaraUnauthenticated(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
