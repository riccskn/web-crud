package com.riccskn.crud.exception;

import com.riccskn.crud.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestControllerExceptionHandler {


    public ResponseEntity<ApiResponse> resolveException(BaseException exception) {

        ApiResponse response = new ApiResponse(exception.getMessage());

        return new ResponseEntity<>(response,exception.getStatus());
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(ResourceNotFoundException exception) {

        ApiResponse response = new ApiResponse(exception.getMessage());

        return new ResponseEntity<>(response,exception.getStatus());

    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(BadRequestException exception) {
        ApiResponse response = new ApiResponse(exception.getMessage());

        return new ResponseEntity<>(response,exception.getStatus());
    }

}
