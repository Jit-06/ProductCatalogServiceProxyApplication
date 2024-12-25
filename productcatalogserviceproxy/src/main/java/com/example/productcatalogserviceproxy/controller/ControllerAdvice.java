package com.example.productcatalogserviceproxy.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handleException(){
        return new ResponseEntity<String>("Code Damage", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
