package com.levi.demo.utils;

import org.springframework.http.HttpStatus;

public enum StatusCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY);

    private HttpStatus httpStatus;

    StatusCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
