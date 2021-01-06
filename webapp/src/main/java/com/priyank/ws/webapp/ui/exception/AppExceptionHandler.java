package com.priyank.ws.webapp.ui.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest req)
    {
        return new ResponseEntity<Object>(ex, new HttpHeaders(), HttpStatus.OK);
    }
}


