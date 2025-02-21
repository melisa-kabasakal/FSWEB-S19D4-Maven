package com.workintech.s19d1.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
