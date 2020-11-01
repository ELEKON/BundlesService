package com.assessment.BundlesService;

import org.springframework.data.rest.webmvc.support.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex) {

        ExceptionMessage exceptionMessageObj =
                new ExceptionMessage(new Throwable(ex.getMessage().substring(ex.getMessage().indexOf("default message")),ex.getCause()));

        return new ResponseEntity<>(exceptionMessageObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
