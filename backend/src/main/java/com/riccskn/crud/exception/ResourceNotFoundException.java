package com.riccskn.crud.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException{
    public ResourceNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
