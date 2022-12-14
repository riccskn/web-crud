package com.riccskn.crud.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{
    public BadRequestException(HttpStatus status, String message) {
        super(status, message);
    }
}
