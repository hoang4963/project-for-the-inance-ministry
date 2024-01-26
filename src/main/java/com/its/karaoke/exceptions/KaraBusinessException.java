package com.its.karaoke.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class KaraBusinessException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    private String message;

    private String[] errors = new String[]{};

    public KaraBusinessException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
    }

    public KaraBusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public KaraBusinessException(String message, HttpStatus status, String[] errors) {
        super(message);
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
