package com.example.SpringSecurityStudy.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // This method will handler the @Valid annotation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> validationError(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().getFirst().getDefaultMessage();
        StandartError err = new StandartError(HttpStatus.BAD_REQUEST.value(), message, System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    // This method will handler Generic Runtime Exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandartError> runtimeError(RuntimeException e) {
        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}