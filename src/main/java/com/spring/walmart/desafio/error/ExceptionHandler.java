package com.spring.walmart.desafio.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Log4j2
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value= RuntimeException.class)
    protected ResponseEntity<ExceptionInfoJson> handleConstraintError(
            RuntimeException ex, WebRequest request) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionInfoJson(request.getContextPath(), ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getClass().getName()), new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }


}
