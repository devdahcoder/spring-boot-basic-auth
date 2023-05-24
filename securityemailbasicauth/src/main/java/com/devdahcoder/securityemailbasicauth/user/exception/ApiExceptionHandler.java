package com.devdahcoder.securityemailbasicauth.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException) {

        ApiException apiException = new ApiException(

                apiRequestException.getMessage(),

                apiRequestException.getCause(),

                HttpStatus.BAD_REQUEST,

                ZonedDateTime.now(ZoneId.of("Z"))

        );

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);

    }
}
