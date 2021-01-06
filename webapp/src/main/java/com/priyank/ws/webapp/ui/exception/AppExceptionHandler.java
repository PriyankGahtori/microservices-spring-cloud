package com.priyank.ws.webapp.ui.exception;

import java.util.Date;

import com.priyank.ws.webapp.ui.model.response.ErrorMsgRes;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest req)
    {
        ErrorMsgRes errorMsg = new ErrorMsgRes(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handleNPException(NullPointerException ex, WebRequest req)
    {
        String msg = ex.getLocalizedMessage() == null ? ex.toString(): ex.getLocalizedMessage();
        ErrorMsgRes errorMsg = new ErrorMsgRes(new Date(), msg);
        return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


