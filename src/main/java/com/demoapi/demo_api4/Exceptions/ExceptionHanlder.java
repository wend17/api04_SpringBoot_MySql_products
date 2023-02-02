package com.demoapi.demo_api4.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHanlder extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class })
    public ResponseEntity<Object> handleException2(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex,"error interno",
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
}
