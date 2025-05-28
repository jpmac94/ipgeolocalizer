package com.interview.ipgeolocalizer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> generalErrorHandler(Exception ex){
        Map<String,Object> response=new HashMap<>();
        response.put("Error","Internal server error");
        response.put("message",ex.getMessage());
        response.put("code",500);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidIp.class)
    public ResponseEntity<Map<String,Object>> invalidIpErrorHandler(Exception ex){
        Map<String,Object> response=new HashMap<>();
        response.put("Error","Invalid ip");
        response.put("message",ex.getMessage());
        response.put("code",400);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,Object>> cotizationNotAvailableErrorHandler(Exception ex){
        Map<String,Object> response=new HashMap<>();
        response.put("Error","Cotization not available");
        response.put("message",ex.getMessage());
        response.put("code",404);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
